package com.test.fasoo.controller;


import com.test.fasoo.dto.AuthUserRequest;
import com.test.fasoo.dto.AuthUserResponse;
import com.test.fasoo.service.AuthUserService;
import com.test.fasoo.vo.AuthUser;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/data-auth")
@RequiredArgsConstructor
public class DataAuthController {

    private final AuthUserService authUserService;

    //유저 권한 생성
    @PostMapping("")
    public AuthUserResponse createAuthUser(@RequestBody AuthUserRequest authUserRequest){
        //Access Token의 userId를 활용해서 관리자인지 판단하는 코드 추가

        AuthUserResponse authUserRes;
        authUserRes = authUserService.createUserAuth(authUserRequest);

        return authUserRes;
    }

    //유저 권한 조회
    @GetMapping("")
    public AuthUser getAuthUser(@RequestHeader String userId, @RequestParam String authTypeName, String dataId){
        AuthUser authUser;

        authUser = authUserService.getAuthUser(userId, authTypeName, dataId);
        System.out.println(authUser);
        return authUser;
    }

    @PutMapping("")
    public AuthUserResponse updateAuthUser(@RequestBody AuthUserRequest authUserRequest){
        AuthUserResponse authUserRes;

        authUserRes = authUserService.updateAuthUser(authUserRequest);


        return authUserRes;
    }

    @GetMapping("/list")
    public List<AuthUserRequest> getUserList(@RequestParam String userId){
        List<AuthUserRequest> userList;

        userList = authUserService.getUserList(userId);

        return userList;
    }

    @GetMapping("/list/me")
    public List<AuthUserRequest> getAuthList(@RequestParam String userId){
        List<AuthUserRequest> authList;

        authList = authUserService.getAuthList(userId);

        return authList;
    }

}