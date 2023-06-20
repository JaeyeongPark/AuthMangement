package com.test.fasoo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthIdDto {
    String auth_user_id;
    String resource_id;
}
