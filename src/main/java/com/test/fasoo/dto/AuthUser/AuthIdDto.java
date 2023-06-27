package com.test.fasoo.dto.AuthUser;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/*
    createAuthUser에서 권한 정보를 반환하기 위한 객체
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthIdDto {
    String authUserId;
    String resourceId;
}
