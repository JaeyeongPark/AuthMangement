package com.test.fasoo.service;

import com.test.fasoo.dto.AuthIdDto;
import com.test.fasoo.dto.AuthInfoDto;
import com.test.fasoo.dto.AuthInfoListResponse;
import com.test.fasoo.dto.AuthUserRequest;
import com.test.fasoo.mapper.AuthUserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthUserService {
    private final AuthUserMapper authUserMapper;


    //유저 권한 추가
    @Transactional
    public List<AuthIdDto> createAuthUser(AuthUserRequest authUserRequest) {
        //데이터베이스에 권한 추가
        int rowsAffected = authUserMapper.createAuthUser(authUserRequest);

        //생성된 id 조회
        List<AuthIdDto> authIdList = authUserMapper.getCreateId(authUserRequest.getRequestId());

        return authIdList;
    }
    //유저 권한 조회
    public AuthInfoDto getAuthUser(String userId, String authTypeId, String dataId){
        return authUserMapper.getAuthUser(userId, authTypeId, dataId);
    }

    public List<AuthIdDto> updateAuthUser(AuthUserRequest authUserRequest){
        //데이터베이스에 권한 추가
        int rowsAffected = authUserMapper.updateAuthUser(authUserRequest);

        //생성된 데이터 조회

        List<AuthIdDto> authIdList = authUserMapper.getCreateId(authUserRequest.getRequestId());

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
