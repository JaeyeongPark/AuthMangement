package com.test.fasoo.mapper;

import com.test.fasoo.dto.UserRole.UserRoleRequest;
import com.test.fasoo.vo.UserRoleVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserRoleMapper {

    public int insertUserRole(UserRoleRequest userRoleRequest);

    public UserRoleVO selectUserRoleByUserId(String userId);
}
