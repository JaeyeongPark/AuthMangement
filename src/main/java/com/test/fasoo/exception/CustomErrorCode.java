package com.test.fasoo.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum CustomErrorCode implements ErrorCode {

    UNDEFINED_AUTH_TYPE(HttpStatus.BAD_REQUEST,"UNDEFINED_AUTH_TYPE", "존재하지 않는 권한 유형입니다."),
    DUPLICATED_AUTH(HttpStatus.BAD_REQUEST,"DUPLICATED_AUTH","이미 권한이 존재합니다."),
    BEGIN_AFTER_EXPIRE(HttpStatus.BAD_REQUEST,"BEGIN_AFTER_EXPIRE","권한 시작일이 만료일 이후 입니다."),
    DUPLICATED_REQUEST_ID(HttpStatus.BAD_REQUEST,"DUPLICATED_REQUEST_ID", "신청 ID가 중복됩니다."),
    INVALID_TOKEN(HttpStatus.UNAUTHORIZED, "INVALID_TOKEN","신청 ID가 중복됩니다."),
    INVALID_PARAMETER(HttpStatus.BAD_REQUEST,"INVALID_PARAMETER","Invalid parameter included"),
    ;

    CustomErrorCode(HttpStatus httpStatus, String code, String message){
        this.httpStatus = httpStatus;
        this.code = code;
        this.message = message;
    }

    private final HttpStatus httpStatus;
    private final String code;
    private final String message;
}
