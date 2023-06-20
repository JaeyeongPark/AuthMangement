package com.test.fasoo.dto;


import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthUserRequest {

    @NotNull
    private String authTypeId;
    @NotNull
    private String userId;
    @NotNull
    private String requestId;
    @NotNull
    private List<String> resourceIdList;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate beginDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate expireDate;


}
