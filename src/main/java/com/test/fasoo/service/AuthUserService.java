package com.test.fasoo.service;


import com.test.fasoo.dto.AuthUser.AuthIdDto;
import com.test.fasoo.dto.AuthUser.AuthInfoDto;
import com.test.fasoo.dto.AuthUser.AuthInfoListResponse;
import com.test.fasoo.dto.AuthUser.AuthUserRequest;
import com.test.fasoo.dto.CheckAuthRequest;
import com.test.fasoo.exception.CustomErrorCode;
import com.test.fasoo.exception.CustomException;
import com.test.fasoo.mapper.AuthUserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthUserService {
    private final AuthUserMapper authUserMapper;


    //유저 권한 추가
    @Transactional
    public List<AuthIdDto> createAuthUser(AuthUserRequest authUserRequest) {

        if(authUserRequest.getBeginDate().isAfter(authUserRequest.getExpireDate())){
            throw new CustomException(CustomErrorCode.BEGIN_AFTER_EXPIRE);
        }

        //request_id 중복 조회
        if (authUserMapper.checkRequestIdDuplicate(authUserRequest.getRequestId()) > 0){
            throw new CustomException(CustomErrorCode.DUPLICATED_REQUEST_ID);
        }

        try{
            authUserMapper.createAuthUser(authUserRequest);
        }catch (DataIntegrityViolationException e){
            SQLException cause = (SQLException) e.getCause();

            if(cause.getErrorCode() == 1062){     // UNIQUE 조건 위반
                throw new CustomException(CustomErrorCode.DUPLICATED_AUTH);
            }else if(cause.getErrorCode() == 1452){     // FK 조건 위반
                throw new CustomException(CustomErrorCode.UNDEFINED_AUTH_TYPE);
            } else{
                throw new RuntimeException("UNEXPECTED_ERROR_EXECUTING_QUERY");
            }
        }catch (Exception e){
            throw new RuntimeException("UNEXPECTED_ERROR_EXECUTING_QUERY");
        }


        //생성된 id 조회
        List<AuthIdDto> authIdList = authUserMapper.getAuthByRequestId(authUserRequest.getRequestId());


        return authIdList;
    }

    //유저 권한 조회
    public AuthInfoDto getAuthUser(CheckAuthRequest checkAuthRequest){
        AuthInfoDto authInfoDto = new AuthInfoDto();

        try{
            authInfoDto = authUserMapper.getAuthUser(checkAuthRequest);

            if (authInfoDto == null){
                throw new CustomException(CustomErrorCode.NOT_FOUND_AUTH);
            }
        }catch(RuntimeException e){
            throw new RuntimeException("UNEXPECTED_ERROR_EXECUTING_QUERY");
        }catch (Exception e){
            throw new RuntimeException("UNEXPECTED_ERROR_EXECUTING_QUERY");
        }


        return authInfoDto;
    }

    public List<AuthIdDto> updateAuthUser(AuthUserRequest authUserRequest){
        //데이터베이스에 권한 추가
        int rowsAffected = authUserMapper.updateAuthUser(authUserRequest);

        //생성된 데이터 조회

        List<AuthIdDto> authIdList = authUserMapper.getAuthByRequestId(authUserRequest.getRequestId());

        return authIdList;
    }

    public int deleteAuthUser(String userId, String authTypeId, String dataId){
        return authUserMapper.deleteAuthUser(userId, authTypeId, dataId);
    }

    //권한 목록 조회(관리자)
    public AuthInfoListResponse getUserList(String userId, String authTypeId, int limit, int offset, int order){
        AuthInfoListResponse authListResponse = new AuthInfoListResponse();

        authListResponse.setTotalCount(authUserMapper.getUserCount(authTypeId));
        authListResponse.setAuthInfoList(authUserMapper.getUserList(userId, authTypeId, limit,offset,order));
        return authListResponse;
    }
    //권한 목록 조회(유저)
    public AuthInfoListResponse getAuthList(String userId, int limit, int offset, int order){

        AuthInfoListResponse authListResponse = new AuthInfoListResponse();

        authListResponse.setAuthInfoList(authUserMapper.getAuthList(userId, limit, offset, order));
        authListResponse.setTotalCount(authUserMapper.getAuthCount(userId));
        return authListResponse;
    }

}
