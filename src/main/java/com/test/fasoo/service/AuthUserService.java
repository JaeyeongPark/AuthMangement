package com.test.fasoo.service;

import com.test.fasoo.dto.AuthUserRequest;
import com.test.fasoo.dto.AuthUserResponse;
import com.test.fasoo.mapper.AuthUserMapper;
import com.test.fasoo.vo.AuthUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.ibatis.session.SqlSession;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthUserService {
    @Autowired
    private AuthUserMapper authUserMapper;


    //유저 권한 추가
    @Transactional
    public AuthUserResponse createUserAuth(AuthUserRequest authUserRequest) {
        /*
         // 중복된 데이터 삽입 확인
         boolean isDuplicate = authUserMapper.checkDuplicateDate(authUserRequest);
         if(isDuplicate){
            return null;
         }
         */

        //데이터베이스에 권한 추가
        int rowsAffected = authUserMapper.createAuthUser(authUserRequest);

        if (rowsAffected <= 0){
            return null;
        }

        //생성된 데이터 조회
        List<AuthUser> authUserList = authUserMapper.getCreateAuth(authUserRequest.getRequestId());

        AuthUserResponse authUserRes = new AuthUserResponse();
        if (authUserList != null && !authUserList.isEmpty()){
            List<String> dataList = new ArrayList<>();

            for (AuthUser authUser : authUserList){
                System.out.println(authUser);
                dataList.add(authUser.getDataId());
            }


            authUserRes.setAuthTypeId(authUserList.get(0).getAuthTypeId());
            authUserRes.setUserId(authUserList.get(0).getUserId());
            authUserRes.setRequestId(authUserList.get(0).getRequestId());
            authUserRes.setDataList(dataList);
            authUserRes.setBeginDate(authUserList.get(0).getBeginDate());
            authUserRes.setExpireDate(authUserList.get(0).getExpireDate());
            authUserRes.setCreateDate(authUserList.get(0).getCreateTime());
            authUserRes.setUpdateDate(authUserList.get(0).getUpdateTime());
        }

        return authUserRes;
    }
    //유저 권한 조회
    public AuthUser getAuthUser(String userId, String authTypeName, String dataId){
        return authUserMapper.getAuthUser(userId, authTypeName, dataId);
    }

    public AuthUserResponse updateAuthUser(AuthUserRequest authUserRequest){
        /*
         // 중복된 데이터 삽입 확인
         boolean isDuplicate = authUserMapper.checkDuplicateDate(authUserRequest);
         if(isDuplicate){
            return null;
         }
         */

        //데이터베이스에 권한 추가
        int rowsAffected = authUserMapper.updateAuthUser(authUserRequest);

        if (rowsAffected <= 0){
            return null;
        }

        //생성된 데이터 조회
        List<AuthUser> authUserList = authUserMapper.getCreateAuth(authUserRequest.getRequestId());

        AuthUserResponse authUserRes = new AuthUserResponse();
        if (authUserList != null && !authUserList.isEmpty()){
            List<String> dataList = new ArrayList<>();

            for (AuthUser authUser : authUserList){
                System.out.println(authUser);
                dataList.add(authUser.getDataId());
            }


            authUserRes.setAuthTypeId(authUserList.get(0).getAuthTypeId());
            authUserRes.setUserId(authUserList.get(0).getUserId());
            authUserRes.setRequestId(authUserList.get(0).getRequestId());
            authUserRes.setDataList(dataList);
            authUserRes.setBeginDate(authUserList.get(0).getBeginDate());
            authUserRes.setExpireDate(authUserList.get(0).getExpireDate());
            authUserRes.setCreateDate(authUserList.get(0).getCreateTime());
            authUserRes.setUpdateDate(authUserList.get(0).getUpdateTime());
        }

        return authUserRes;
    }
    //권한 목록 조회(관리자)
    public List<AuthUserRequest> getUserList(String userId){
        return authUserMapper.getUserList(userId);
    }
    //권한 목록 조회(유저)
    public List<AuthUserRequest> getAuthList(String userId){
        return authUserMapper.getAuthList(userId);
    }
}
