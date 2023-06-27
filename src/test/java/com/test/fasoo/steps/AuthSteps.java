package com.test.fasoo.steps;

import com.test.fasoo.dto.AuthUser.AuthIdDto;
import com.test.fasoo.dto.AuthUser.AuthIdListResponse;
import com.test.fasoo.dto.AuthUser.AuthUserRequest;
import com.test.fasoo.dto.AuthUser.CheckAuthRequest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AuthSteps {
    public static AuthIdListResponse 권한생성응답_생성() {
        AuthIdDto authIdDto1 = new AuthIdDto();
        authIdDto1.setResourceId("Data1");
        authIdDto1.setAuthUserId("1");

        AuthIdDto authIdDto2 = new AuthIdDto();
        authIdDto2.setResourceId("Data2");
        authIdDto2.setAuthUserId("1");

        List<AuthIdDto> list = new ArrayList<>();
        list.add(authIdDto1);
        list.add(authIdDto2);

        AuthIdListResponse authIdListDto = new AuthIdListResponse();
        authIdListDto.setAuthIdDtoList(list);

        return authIdListDto;

    }


    public static AuthUserRequest 권한생성요청_생성() {
        String authTypeId = "Data_user";
        String userId = "pjys211";
        String requestId = "request1";
        List<String> resourceIdList = new ArrayList<>();
        resourceIdList.add("data1");
        resourceIdList.add("data2");
        LocalDate beginDate = LocalDate.of(2023,06,30);
        LocalDate expireDate = LocalDate.of(2023,07,30);

        return new AuthUserRequest(authTypeId,userId,requestId,resourceIdList,beginDate,expireDate);
    }

    public static CheckAuthRequest 권한조회요청_생성() {
        String userId = "pjys211";
        String authTypeName = "Data_use";
        String resourceId = "data1";

        return new CheckAuthRequest(userId,authTypeName,resourceId);
    }
}
