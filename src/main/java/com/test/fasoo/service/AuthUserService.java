package com.test.fasoo.service;

import com.test.fasoo.dto.AuthUserRequest;
import com.test.fasoo.dto.AuthUserResponse;
import com.test.fasoo.mapper.AuthUserMapper;
import com.test.fasoo.vo.AuthUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthUserService {
    @Autowired
    private AuthUserMapper authUserMapper;

    //유저 권한 추가
    public AuthUserResponse createUserAuth(AuthUserRequest authUserRequest) {
        authUserMapper.createAuthUser(authUserRequest);

        List<AuthUser> authUserList = authUserMapper.getCreateAuth(authUserRequest.getRequestId());

        List<String> dataList = new ArrayList<>();

        for (AuthUser authUser : authUserList){
            dataList.add(authUser.getDataId());
        }

        AuthUserResponse authUserRes = new AuthUserResponse();
        authUserRes.setAuthTypeId(authUserList.get(0).getAuthTypeId());
        authUserRes.setRequestId(authUserList.get(0).getRequestId());
        authUserRes.setDataList(dataList);
        authUserRes.setBeginDate(authUserList.get(0).getBeginDate());
        authUserRes.setExpireDate(authUserList.get(0).getExpireDate());
        authUserRes.setCreateTime(authUserList.get(0).getCreateTime());
        authUserRes.setUpdateTime(authUserList.get(0).getUpdateTime());

        return authUserRes;
    }
    //유저 권한 조회
    public AuthUserRequest readUserAuth(String userId){
        return authUserMapper.readAuthUser(userId);
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
