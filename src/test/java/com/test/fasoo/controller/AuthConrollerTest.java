package com.test.fasoo.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.fasoo.dto.AuthUser.AuthUserRequest;
import com.test.fasoo.dto.AuthUser.CheckAuthRequest;
import com.test.fasoo.service.AuthUserService;
import com.test.fasoo.steps.AuthSteps;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;


@WebMvcTest(AuthController.class)
public class AuthConrollerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;


    @MockBean
    private AuthUserService authUserService;


    @DisplayName("권한 생성")
    @Test
    public void 컨트롤러_권한생성() throws Exception{

        AuthUserRequest authUserRequest = AuthSteps.권한생성요청_생성();

//        AuthIdListResponse authIdListDto = AuthSteps.권한생성응답_생성();


        String jsonRequest = objectMapper.writeValueAsString(authUserRequest);
//        String jsonResponse = objectMapper.writeValueAsString(authIdListDto);


        mockMvc.perform(
                    MockMvcRequestBuilders.post("/auth")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonRequest))
                .andExpect(MockMvcResultMatchers.status().isOk());
//              .andExpect(MockMvcResultMatchers.content().json(jsonResponse,false);
    }

    @DisplayName("권한 조회")
    @Test
    public void 컨트롤러_권한조회() throws Exception{
        CheckAuthRequest checkAuthRequest = new CheckAuthRequest("pjys211","Data_use","resouceId");

        mockMvc.perform(
                        MockMvcRequestBuilders.get("/auth")
                                .param("userId","pjys211")
                                .param("authTypeId","Data_use")
                                .param("resourceId","data1")
                                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
//              .andExpect(MockMvcResultMatchers.content().json(jsonResponse,false);
    }


}
