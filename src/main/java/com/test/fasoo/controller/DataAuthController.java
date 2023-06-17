package com.test.fasoo.controller;


import com.test.fasoo.dto.AuthListResponse;
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
    public AuthUserResponse createAuthUser(@RequestHeader String adminUserId,@RequestBody AuthUserRequest authUserRequest){
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
    public AuthUserResponse updateAuthUser(@RequestHeader String adminUserId, @RequestBody AuthUserRequest authUserRequest){
        AuthUserResponse authUserRes;

        authUserRes = authUserService.updateAuthUser(authUserRequest);


        return authUserRes;
    }

    @DeleteMapping("")
    public int deleteAuthUser(@RequestHeader String adminUserId, @RequestParam String userId,String authTypeName, String dataId){

        return authUserService.deleteAuthUser(userId, authTypeName, dataId);
    }

    //관리자가 권한을 가지고 있는 유저 목록을 조회
    @GetMapping("/list")
    public List<AuthUser> getUserList(@RequestHeader String userId, @RequestParam(required = false) String authTypeName, int limit, int offset, int order) {
        List<AuthUser> userList;

        userList = authUserService.getUserList(userId,authTypeName, limit, offset, order);

        return userList;
    }

    //유저가 가지고 있는 권한 목록 조회
    @GetMapping("/list/me")
    public AuthListResponse getAuthList(@RequestHeader String userId, @RequestParam(required = false, defaultValue = "10")int limit, @RequestParam(required = false, defaultValue = "1")int offset, @RequestParam(required = false, defaultValue = "0")int order){
        AuthListResponse authList;

        authList = authUserService.getAuthList(userId, limit, offset, order);

        return authList;
    }

}
