package com.test.fasoo.dto;


import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthUserRequest {

    @NotEmpty(message = "권한 타입은 필수입니다.")
    private String authTypeId;
    @NotEmpty(message = "유저 ID는 필수입니다.")
    private String userId;
    @NotEmpty(message = "요청 ID는 필수입니다.")
    private String requestId;
    @NotEmpty(message = "리소스 ID는 필수입니다.")
    private List<String> resourceIdList;

//    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "권한 시작일은 필수입니다.")
    private LocalDate beginDate;


//    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "권한 만료일은 필수입니다.")
    private LocalDate expireDate;


}
