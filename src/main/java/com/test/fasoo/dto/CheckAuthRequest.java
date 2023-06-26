package com.test.fasoo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CheckAuthRequest {

    @NotEmpty(message = "유저 ID는 필수입니다.")
    String userId;
    @NotEmpty(message = "권한 유형은 필수입니다.")
    String authTypeName;
    @NotEmpty(message = "리소스 ID는 필수입니다.")
    String resourceId;
}
