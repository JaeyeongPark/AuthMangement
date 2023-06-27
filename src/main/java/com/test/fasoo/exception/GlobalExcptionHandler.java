package com.test.fasoo.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExcptionHandler extends ResponseEntityExceptionHandler {


    // ---------------------- RuntimeException 예외처리 (예기치 못한 문제 발생) ---------------------------
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Object> handleCustomException(RuntimeException e){
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setCode("INTERNAL_SERVER_ERROR");
        errorResponse.setMessage("예기치 못한 문제가 발생하여 요청이 실패했습니다.");

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(errorResponse);
    }



    //-----------CustomException 예외처리 --------------------------
    @ExceptionHandler(CustomException.class)
    public ResponseEntity<Object> handleCustomException(CustomException e){
        ErrorCode errorCode = e.getErrorCode();
        return handleExceptionInternal(errorCode);
    }

    //handleExceptionInternal과 makeErrorResponse를 만들었을 때 장점?
    private ResponseEntity<Object> handleExceptionInternal(ErrorCode errorCode) {
        return ResponseEntity.status(errorCode.getHttpStatus())
                .body(makeErrorResponse(errorCode));
    }

    private ErrorResponse makeErrorResponse(ErrorCode errorCode){
        ErrorResponse errorResponse = new ErrorResponse(errorCode.getCode(),errorCode.getMessage());
        return errorResponse;
    }


    // ---------------@Valid 예외처리----------------------------
    /*
        @Valid에 의한 MethodArgumentNotValidException의 경우 에러 필드와 메시지를 추가해줘야함
        관련 정보는 MethodArgumentNotValidException의 getBindingResult를 통해서 얻을 수 있음.
        참고 : https://mangkyu.tistory.com/205
     */
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ErrorCode errorCode = CustomErrorCode.INVALID_PARAMETER;
        return handleExceptionInternal(ex, errorCode);
    }

    private ResponseEntity<Object> handleExceptionInternal(BindException e, ErrorCode errorCode) {
        return ResponseEntity.status(errorCode.getHttpStatus())
                .body(makeErrorResponse(e, errorCode));
    }


    private ErrorResponse makeErrorResponse(BindException e, ErrorCode errorCode){
        List<ErrorResponse.ValidationError> validationErrorList = e.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(ErrorResponse.ValidationError::of)
                .collect(Collectors.toList());


        return new ErrorResponse(
                errorCode.getCode(),
                errorCode.getMessage(),
                validationErrorList
        );
    }

    // --------------@Valid 예외처리---------------------------


}