package com.test.fasoo.dto;

import lombok.*;
import javax.validation.constraints.NotNull;
import java.util.List;



@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthListResponse {
    List<AuthInfoDto> authInfoList;
    int totalCount;
}
