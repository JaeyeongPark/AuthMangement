package com.test.fasoo.dto.AuthUser;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthIdDto {
    String authUserId;
    String resourceId;
}
