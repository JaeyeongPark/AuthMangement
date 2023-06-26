package com.test.fasoo.controller;


import com.test.fasoo.dto.AuthUser.AuthUserRequest;
import com.test.fasoo.service.AuthUserService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebMvcTest(AuthController.class)
public class AuthConrollerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AuthUserService authUserService;


    @DisplayName("권한 생성")
    @Test
    void 권한생성() throws Exception{
        List<String> resourceIdList = new ArrayList<>();
        resourceIdList.add("data1");
        resourceIdList.add("data2");
        resourceIdList.add("data3");

        AuthUserRequest authUserRequest = new AuthUserRequest();
        authUserRequest.setAuthTypeId("Data_user");
        authUserRequest.setUserId("pjys211");
        authUserRequest.setRequestId("request1");
        authUserRequest.setResourceIdList(resourceIdList);
        authUserRequest.setBeginDate(LocalDate.of(2023,06,30));
        authUserRequest.setExpireDate(LocalDate.of(2023,07,30));



//        given(authUserSevice.createAuthUser())

    }

}
