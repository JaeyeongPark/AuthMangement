package com.test.fasoo.dto.AuthUser;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;


/*
    사용자의 권한 정보를 응답할 때 사용되는 클래스
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthInfoDto {
    private Long id;
    private String authTypeId;
    private String requestId;
    private String userId;
    private String resourceId;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate beginDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate expireDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate createDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate updateDate;
}
