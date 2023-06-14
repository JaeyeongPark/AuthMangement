package com.test.fasoo.mapper;

import com.test.fasoo.dto.AuthUserRequest;
import com.test.fasoo.vo.AuthUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AuthUserMapper {
    public int createAuthUser(AuthUserRequest authUserRequest);
    public List<AuthUser> getCreateAuth(String requestId);
    public AuthUser getAuthUser(String userId, String authTypeName, String dataId);
    public int updateAuthUser(AuthUserRequest authUserRequest);

    public int deleteAuthUser(String userId, String authTypeName, String dataId);
    public List<AuthUserRequest> getUserList(String userId);

    public List<AuthUserRequest> getAuthList(String userId);

}
