package com.test.fasoo.dto.AuthUser;

import lombok.*;

import java.util.List;

/*
    권한 목록을 응답하기 위한 객체
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthInfoListResponse {
    List<AuthInfoDto> authInfoList;
    int totalCount;
}
