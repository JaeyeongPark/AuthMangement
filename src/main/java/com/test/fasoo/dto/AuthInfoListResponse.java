package com.test.fasoo.dto;

import lombok.*;

import java.util.List;



@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthInfoListResponse {
    List<AuthInfoDto> authInfoList;
    int totalCount;
}
