package com.test.fasoo.steps;

import com.test.fasoo.dto.AuthUser.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AuthSteps {
    public static List<AuthIdDto> 권한생성응답_생성() {
        AuthIdDto authIdDto1 = new AuthIdDto();
        authIdDto1.setResourceId("DATA1");
        authIdDto1.setAuthUserId("1");

        AuthIdDto authIdDto2 = new AuthIdDto();
        authIdDto2.setResourceId("DATA2");
        authIdDto2.setAuthUserId("2");

        List<AuthIdDto> list = new ArrayList<>();
        list.add(authIdDto1);
        list.add(authIdDto2);

        return list;
    }

    public static AuthInfoDto 권한조회응답_생성(){
        Long id = 1L;
        String authTypeId = "DATA_USE";
        String requestId = "REQUEST_1";
        String userId = "pjys211";
        String resourceId = "DATA_1";
        LocalDate beginDate = LocalDate.of(2023,06,30);
        LocalDate expireDate = LocalDate.of(2023,07,30);
        LocalDate createTime = LocalDate.of(2023,06,30);
        LocalDate updateTime = LocalDate.of(2023,06,30);

        return new AuthInfoDto(id,authTypeId,requestId,userId,resourceId,beginDate,expireDate,createTime,updateTime);
    }


    public static AuthUserRequest 권한생성요청_생성() {
        String authTypeId = "DATA_USE";
        String userId = "pjys211";
        String requestId = "REQUEST1";
        List<String> resourceIdList = new ArrayList<>();
        resourceIdList.add("DATA1");
        resourceIdList.add("DATA2");
        LocalDate beginDate = LocalDate.of(2023,06,30);
        LocalDate expireDate = LocalDate.of(2023,07,30);

        return new AuthUserRequest(authTypeId,userId,requestId,resourceIdList,beginDate,expireDate);
    }

    public static CheckAuthRequest 권한조회요청_생성() {
        String userId = "pjys211";
        String authTypeName = "DATA_USE";
        String resourceId = "DATA_1";

        return new CheckAuthRequest(userId,authTypeName,resourceId);
    }
}
