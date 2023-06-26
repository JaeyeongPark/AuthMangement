package com.test.fasoo.mapper;

import com.test.fasoo.dto.AuthIdDto;
import com.test.fasoo.dto.AuthInfoDto;
import com.test.fasoo.dto.AuthUserRequest;
import com.test.fasoo.dto.CheckAuthRequest;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AuthUserMapper {
    public int createAuthUser(AuthUserRequest authUserRequest);
    public int checkRequestIdDuplicate(String requestId);
    public List<AuthIdDto> getAuthByRequestId(String requestId);
    public AuthInfoDto getAuthUser(CheckAuthRequest checkAuthRequest);
    public int updateAuthUser(AuthUserRequest authUserRequest);

    public int deleteAuthUser(String userId, String authTypeId, String dataId);
    public List<AuthInfoDto> getUserList(String userId,String authTypeId, int limit, int offset, int order);
    public int getUserCount(String authTypeId);
    public List<AuthInfoDto> getAuthList(String userId, int limit, int offset, int order);
    public int getAuthCount(String userId);
}
