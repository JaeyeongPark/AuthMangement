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

        AuthIdDto authIdDto1 = new AuthIdDto("9","DATA0");
        AuthIdDto authIdDto2 = new AuthIdDto("10","DATA1");
        AuthIdDto authIdDto3 = new AuthIdDto("11","DATA2");
        AuthIdDto authIdDto4 = new AuthIdDto("12","DATA3");
        List<AuthIdDto> authIdDtoList = new ArrayList<>();
        authIdDtoList.add(authIdDto1);
        authIdDtoList.add(authIdDto2);
        authIdDtoList.add(authIdDto3);
        authIdDtoList.add(authIdDto4);


        List<AuthIdDto> result = authUserMapper.getAuthByRequestId("REQUEST0");

        assertNotNull(result);
        assertEquals(result,authIdDtoList);
    }
    //권한 생성시 사용되는 메서드
    @DisplayName("맵퍼_getAuthUser테스트")
    @Test
    public void 맵퍼_getAuthUser(){
        CheckAuthRequest checkAuthRequest = new CheckAuthRequest("pjys211","DATA_USE","DATA0");

        Long id = 9L;
        String authTypeId = "DATA_USE";
        String requestId = "REQUEST0";
        String userId = "pjys211";
        String resourceId = "DATA0";
        LocalDate beginDate = LocalDate.of(2023,8,30);
        LocalDate expireDate = LocalDate.of(2023,9,30);
        LocalDate createDate = LocalDate.of(2023,8,1);
        LocalDate updateDate = LocalDate.of(2023,8,1);

        AuthInfoDto expectedAuthInfo = new AuthInfoDto(id,authTypeId,requestId,userId,resourceId,beginDate,expireDate,createDate,updateDate);

        AuthInfoDto result = authUserMapper.getAuthUser(checkAuthRequest);
        System.out.println(result);
        assertNotNull(result);
        assertEquals(result, expectedAuthInfo);

    }
    
    //권한 조회시 사용되는 메서드


}
