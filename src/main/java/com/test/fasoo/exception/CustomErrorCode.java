package com.test.fasoo.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum CustomErrorCode implements ErrorCode {


    UNDEFINED_AUTH_TYPE(HttpStatus.BAD_REQUEST, "INVALID_AUTH_TYPE", "존재하지 않는 권한 유형입니다."),
    DUPLICATED_AUTH(HttpStatus.BAD_REQUEST, "DUPLICATEㅊㅇ 햣D_AUTH", "이미 권한이 존재합니다."),
    BEGIN_AFTER_EXPIRE(HttpStatus.BAD_REQUEST, "BEGIN_AFTER_EXPIRE", "권한 시작일이 만료일 이후 입니다."),
    DUPLICATED_REQUEST_ID(HttpStatus.BAD_REQUEST, "DUPLICATED_REQUEST_ID", "신청 ID가 중복됩니다."),
    NULL_AUTH_TYPE(HttpStatus.BAD_REQUEST, "NULL_AUTH_TYPE", "권한 유형이 비어있습니다."),
    FORBIDDEN_REQUEST(HttpStatus.FORBIDDEN, "FORBIDDEN_REQUEST", "허용되지 않은 요청입니다."),
    UNSUPPORTED_HEADER(HttpStatus.BAD_REQUEST, "UNSUPPORTED_HEADER", "올바르지 않은 헤더입니다."),
    INVALID_TOKEN(HttpStatus.UNAUTHORIZED, "INVALID_TOKEN", "유효하지 않은 토큰입니다."),
    INVALID_DATE_FORMAT(HttpStatus.BAD_REQUEST, "INVALID_DATE_FORMAT", "유효하지 않은 날짜 형태입니다."),
    INVALID_PARAMETER(HttpStatus.BAD_REQUEST,"INVALID_PARAMETER","유효하지 않은 파라미터입니다."),


    //getAuthUser 예외처리
    NOT_FOUND_AUTH(HttpStatus.BAD_REQUEST,"NOT_FOUND_AUTH","권한이 존재하지 않습니다.");



    private HttpStatus httpStatus;
    private String code;
    private String message;
}
