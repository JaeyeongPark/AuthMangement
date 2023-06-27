package com.test.fasoo.dto.AuthUser;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;


/*
    권한 조회에서 사용자에게 요청받는 클래스
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CheckAuthRequest {

    @NotEmpty(message = "유저 ID는 필수입니다.")
    String userId;
    @NotEmpty(message = "권한 유형은 필수입니다.")
    String authTypeId;
    @NotEmpty(message = "리소스 ID는 필수입니다.")
    String resourceId;
}
