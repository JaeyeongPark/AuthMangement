package com.test.fasoo.service;

import com.test.fasoo.dto.AuthUser.AuthIdListResponse;
import com.test.fasoo.dto.AuthUser.AuthUserRequest;
import com.test.fasoo.mapper.AuthUserMapper;
import com.test.fasoo.steps.AuthSteps;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.stubbing.OngoingStubbing;

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

    @DisplayName("권한 생성")
    @Test
    public void 서비스_권한생성(){
//        Mock데이터
        AuthUserRequest mockAuthUserRequest = AuthSteps.권한생성요청_생성();

        AuthIdListResponse mockAuthIdListResponse = AuthSteps.권한생성응답_생성();

        //Mock Mapper 동작 설정
         when(authUserMapper.createAuthUser(any(AuthUserRequest.class)))
                .thenReturn(mockAuthIdListResponse);

        // 테스트 대상 메서드 호출
        AuthIdListResponse result = authUserService.createAuthUser(mockAuthUserRequest);

        // 검증
        Assertions.assertNotNull(result);
        Assertions.assertEquals(mockAuthIdListResponse.getAuthIdDtoList().size(), result.getAuthIdDtoList().size());
        Assertions.assertEquals(mockAuthIdListResponse.getAuthIdDtoList().get(0).getAuthUserId(), result.getAuthIdDtoList().get(0).getAuthUserId());
        Assertions.assertEquals(mockAuthIdListResponse.getAuthIdDtoList().get(0).getResourceId(), result.getAuthIdDtoList().get(0).getResourceId());
    }



}
