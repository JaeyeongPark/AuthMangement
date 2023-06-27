package com.test.fasoo.dto.AuthUser;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


/*
    createAuthUser에서 생성된 권한 정보를 반환하는 리스트
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthIdListResponse {
    List<AuthIdDto> authIdDtoList;
}
