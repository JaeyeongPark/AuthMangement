package com.test.fasoo.dto;

import com.test.fasoo.vo.AuthUser;
import lombok.*;

import java.util.List;



@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AuthListResponse {
    List<AuthUser> authInfoList;
    int totalCount;
}
