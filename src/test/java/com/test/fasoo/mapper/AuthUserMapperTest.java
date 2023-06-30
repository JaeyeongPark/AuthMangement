package com.test.fasoo.mapper;

import com.test.fasoo.dto.AuthUser.*;
import com.test.fasoo.steps.AuthSteps;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Transactional
public class AuthUserMapperTest {

    @Autowired
    private AuthUserMapper authUserMapper;

    //권한 생성시 사용되는 메서드 테스트
    @DisplayName("맵퍼_createAuthUser테스트")
    @Test
    public void 맵퍼_createAuthUser(){
        AuthUserRequest authUserRequest = AuthSteps.권한생성요청_생성();

        int result = authUserMapper.createAuthUser(authUserRequest);

        assertNotNull(result);
        assertEquals(result,authUserRequest.getResourceIdList().size());
    }

    @DisplayName("맵퍼_getAuthByRequestId테스트")
    @Test
    public void 맵퍼_getAuthByRequestId(){

        AuthIdDto authIdDto1 = new AuthIdDto("5","DATA_200000");
        AuthIdDto authIdDto2 = new AuthIdDto("6","DATA_200001");
        List<AuthIdDto> authIdDtoList = new ArrayList<>();
        authIdDtoList.add(authIdDto1);
        authIdDtoList.add(authIdDto2);

        List<AuthIdDto> result = authUserMapper.getAuthByRequestId("REQUEST_1000000");

        assertNotNull(result);
        assertEquals(result,authIdDtoList);
    }
    //권한 생성시 사용되는 메서드
    @DisplayName("맵퍼_getAuthUser테스트")
    @Test
    public void 맵퍼_getAuthUser(){
        CheckAuthRequest checkAuthRequest = new CheckAuthRequest("pjys211","DATA_USE","DATA_200000");

        Long id = 5L;
        String authTypeId = "DATA_USE";
        String requestId = "REQUEST_1000000";
        String userId = "pjys211";
        String resourceId = "DATA_200000";
        LocalDate beginDate = LocalDate.of(2023,06,28);
        LocalDate expireDate = LocalDate.of(2023,07,30);
        LocalDate createDate = LocalDate.of(2023,06,28);
        LocalDate updateDate = LocalDate.of(2023,06,29);

        AuthInfoDto expectedAuthInfo = new AuthInfoDto(id,authTypeId,requestId,userId,resourceId,beginDate,expireDate,createDate,updateDate);

        AuthInfoDto result = authUserMapper.getAuthUser(checkAuthRequest);

        assertNotNull(result);
        assertEquals(result, expectedAuthInfo);

    }
    
    //권한 조회시 사용되는 메서드


}
