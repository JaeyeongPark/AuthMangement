package com.test.fasoo.vo;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class UserRoleVO {
    private Integer id;
    private String adminTypeId;
    private String userId;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
