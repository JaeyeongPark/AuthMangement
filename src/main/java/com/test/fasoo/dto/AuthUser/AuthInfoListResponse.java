package com.test.fasoo.dto.AuthUser;

import lombok.*;

import java.util.List;



@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthInfoListResponse {
    List<AuthInfoDto> authInfoList;
    int totalCount;
}
