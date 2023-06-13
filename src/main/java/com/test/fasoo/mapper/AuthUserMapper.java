package com.test.fasoo.mapper;

import com.test.fasoo.dto.AuthUserRequest;
import com.test.fasoo.vo.AuthUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AuthUserMapper {
    public int createAuthUser(AuthUserRequest authUser);
    public List<AuthUser> getCreateAuth(String requestId);
    public AuthUserRequest readAuthUser(String userId);

    public List<AuthUserRequest> getUserList(String userId);

    public List<AuthUserRequest> getAuthList(String userId);

}
