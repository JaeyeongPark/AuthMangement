package com.test.fasoo.service;

import com.test.fasoo.dto.UserRole.UserRoleResponse;
import com.test.fasoo.mapper.UserRoleMapper;
import com.test.fasoo.vo.UserRoleVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserRoleService {

    private final UserRoleMapper userRoleMapper;

    public UserRoleResponse findUserRoleByUserId(String userId){
        UserRoleVO userRoleVO = userRoleMapper.selectUserRoleByUserId(userId);

        return userRoleVO == null ? null : new UserRoleResponse(userRoleVO);
    }
}
