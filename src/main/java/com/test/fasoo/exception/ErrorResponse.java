package com.test.fasoo.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.springframework.validation.FieldError;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse {
    private String code;
    private String message;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ValidationError> errors;

    public ErrorResponse(String code, String message){
        this.code = code;
        this.message = message;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ValidationError{
        private String field;
        private String message;

        public static ValidationError of(final FieldError fieldError){
            return new ValidationError(
                    fieldError.getField(),
                    fieldError.getDefaultMessage()
            );
        }
    }
}
