package com.test.fasoo.vo;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;



@Getter
public class AuthUserVO {

    private Long id;
    private String authTypeId;
    private String requestId;
    private String userId;
    private String dataId;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date beginDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date expireDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date updateTime;
}
