//package com.test.fasoo.security;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.test.fasoo.exception.CustomErrorCode;
//import com.test.fasoo.exception.ErrorResponse;
//
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//public class SecurityFilterUtil {
//
//    static public void handleFilterException(HttpServletResponse response, CustomErrorCode errorCode) throws IOException {
//
//        response.setStatus(errorCode.getHttpStatus().value());
//
//        response.setContentType("application/json");
//        response.setCharacterEncoding("UTF-8");
//
//        ErrorResponse errorResponse = ErrorResponse.builder()
//                .code(errorCode.getCode())
//                .message(errorCode.getMessage())
//                .build();
//
//        ObjectMapper mapper = new ObjectMapper();
//
//        response.getWriter().write(mapper.writeValueAsString(errorResponse));
//    }
//}