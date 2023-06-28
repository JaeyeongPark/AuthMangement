package com.test.fasoo.service;

import com.test.fasoo.dto.AuthUser.*;
import com.test.fasoo.mapper.AuthUserMapper;
import com.test.fasoo.steps.AuthSteps;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class AuthUserServiceTest {
    @Mock
    private AuthUserMapper authUserMapper;

    @InjectMocks
    private AuthUserService authUserService;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @DisplayName("서비스_권한생성")
    @Test
    public void 서비스_권한생성(){
        //given
        //        Mock데이터
        AuthUserRequest mockAuthUserRequest = AuthSteps.권한생성요청_생성();


        //Mapper에서는 List로 반환 서비스에서는 AuthIdListResponse로 변환해서 반환
        List<AuthIdDto> mockAuthIdListResponse = AuthSteps.권한생성응답_생성();

        AuthIdListResponse expectedResult = new AuthIdListResponse(mockAuthIdListResponse);

        //Mock Mapper 동작 설정
         when(authUserMapper.createAuthUser(mockAuthUserRequest)).thenReturn(mockAuthUserRequest.getResourceIdList().size());
         when(authUserMapper.getAuthByRequestId(mockAuthUserRequest.getRequestId())).thenReturn(mockAuthIdListResponse);


         //when
        AuthIdListResponse result = authUserService.createAuthUser(mockAuthUserRequest);


        //then
        assertNotNull(result);
        assertEquals(result.getAuthIdDtoList(), expectedResult.getAuthIdDtoList());


    }


    @DisplayName("서비스_권한조회")
    @Test
    public void 서비스_권한조회(){
        //given
        //        Mock데이터
        CheckAuthRequest mockCheckAuthRequest = AuthSteps.권한조회요청_생성();

        AuthInfoDto expectedResult = AuthSteps.권한조회응답_생성();

        when(authUserMapper.getAuthUser(mockCheckAuthRequest)).thenReturn(expectedResult);

        //when
        AuthInfoDto result = authUserMapper.getAuthUser(mockCheckAuthRequest);

        //then
        assertNotNull(result);
        assertEquals(result.getId(),expectedResult.getId());
        assertEquals(result.getUserId(),expectedResult.getUserId());
        assertEquals(result.getAuthTypeId(),expectedResult.getAuthTypeId());
        assertEquals(result.getRequestId(),expectedResult.getRequestId());
        assertEquals(result.getResourceId(),expectedResult.getResourceId());
        assertEquals(result.getBeginDate(),expectedResult.getBeginDate());
        assertEquals(result.getExpireDate(),expectedResult.getExpireDate());
        assertEquals(result.getCreateTime(),expectedResult.getCreateTime());
        assertEquals(result.getUpdateTime(),expectedResult.getUpdateTime());

    }



}
