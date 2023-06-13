package com.test.fasoo.dto;


import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AuthUserRequest {
    private String authTypeId;
    private String userId;
    private String requestId;
    private List<String> dataList;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date beginDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date expireDate;


}
