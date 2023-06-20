package com.test.fasoo.controller;


import com.test.fasoo.dto.AuthInfoDto;
import com.test.fasoo.dto.AuthListResponse;
import com.test.fasoo.dto.AuthUserRequest;
import com.test.fasoo.service.AuthUserService;
import com.test.fasoo.vo.AuthUser;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class DataAuthController {

    private final AuthUserService authUserService;

    //유저 권한 생성
    @PostMapping("")
    public ResponseEntity<List<String>> createAuthUser(@RequestHeader String adminUserId, @RequestBody AuthUserRequest authUserRequest){
        //Access Token의 userId를 활용해서 관리자인지 판단하는 코드 추가

        List<String> authUserId = authUserService.createAuthUser(authUserRequest);


        return ResponseEntity.ok().body(authUserId);
    }

    //유저 권한 조회
    @GetMapping("")
    public ResponseEntity<AuthInfoDto> getAuthUser(@RequestHeader String userId, @RequestParam String authTypeName, String dataId){
        AuthInfoDto authInfo;

        authInfo = authUserService.getAuthUser(userId, authTypeName, dataId);

        return ResponseEntity.ok().body(authInfo);
    }

    //유저 권한 수정
    @PutMapping("")
    public ResponseEntity<List<String>> updateAuthUser(@RequestHeader String adminUserId, @RequestBody AuthUserRequest authUserRequest){
        List<String> authUserId = authUserService.updateAuthUser(authUserRequest);


        return ResponseEntity.ok().body(authUserId);
    }

    //유저 권한 삭제
    @DeleteMapping("")
    public ResponseEntity<Integer> deleteAuthUser(@RequestHeader String adminUserId, @RequestParam String userId,String authTypeName, String dataId){

        int result = authUserService.deleteAuthUser(userId, authTypeName,dataId);

        return ResponseEntity.ok().body(result);
    }

    //관리자가 권한을 가지고 있는 유저 목록을 조회
    @GetMapping("/list")
    public AuthListResponse getUserList(@RequestHeader String userId, @RequestParam String authTypeName, @RequestParam(required = false, defaultValue = "0")int limit, @RequestParam(required = false, defaultValue = "0")int offset, @RequestParam(required = false, defaultValue = "0")int order) {
        AuthListResponse userList;

        userList = authUserService.getUserList(userId,authTypeName, limit, offset, order);

        return userList;
    }

    //유저가 가지고 있는 권한 목록 조회
    @GetMapping("/list/me")
    public AuthListResponse getAuthList(@RequestHeader String userId, @RequestParam(required = false, defaultValue = "0")int limit, @RequestParam(required = false, defaultValue = "0")int offset, @RequestParam(required = false, defaultValue = "0")int order){
        AuthListResponse authList;

        authList = authUserService.getAuthList(userId, limit, offset, order);

        return authList;
    }

}
