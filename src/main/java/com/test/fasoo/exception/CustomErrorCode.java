package com.test.fasoo.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum CustomErrorCode implements ErrorCode {

    UNDEFINED_AUTH_TYPE(HttpStatus.BAD_REQUEST, "존재하지 않는 권한 유형입니다."),
    DUPLICATED_AUTH(HttpStatus.BAD_REQUEST, "이미 권한이 존재합니다."),
    BEGIN_AFTER_EXPIRE(HttpStatus.BAD_REQUEST,"권한 시작일이 만료일 이후 입니다."),
    DUPLICATED_REQUEST_ID(HttpStatus.BAD_REQUEST, "신청 ID가 중복됩니다."),
    INVALID_PARAMETER(HttpStatus.BAD_REQUEST,"Invalid parameter included"),
    ;

    private final HttpStatus httpStatus;
    private final String message;
}
