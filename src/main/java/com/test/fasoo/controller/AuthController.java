package com.test.fasoo.controller;


import com.test.fasoo.dto.AuthIdDto;
import com.test.fasoo.dto.AuthInfoDto;
import com.test.fasoo.dto.AuthInfoListResponse;
import com.test.fasoo.dto.AuthUserRequest;
import com.test.fasoo.service.AuthUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthUserService authUserService;

    //유저 권한 생성
    @PostMapping("")
    public ResponseEntity<List<AuthIdDto>> createAuthUser(@RequestHeader String adminUserId, @RequestBody @Valid AuthUserRequest authUserRequest){
        //Access Token의 userId를 활용해서 관리자인지 판단하는 코드 추가

        List<AuthIdDto> authUserId = authUserService.createAuthUser(authUserRequest);


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
    public ResponseEntity<List<AuthIdDto>> updateAuthUser(@RequestHeader String adminUserId, @RequestBody AuthUserRequest authUserRequest){
        List<AuthIdDto> authUserId = authUserService.updateAuthUser(authUserRequest);


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
    public ResponseEntity<AuthInfoListResponse> getUserList(@RequestHeader String userId, @RequestParam String authTypeName, @RequestParam(required = false, defaultValue = "0")int limit, @RequestParam(required = false, defaultValue = "0")int offset, @RequestParam(required = false, defaultValue = "0")int order) {
        AuthInfoListResponse userList;

        userList = authUserService.getUserList(userId,authTypeName, limit, offset, order);

        return ResponseEntity.ok().body(userList);
    }

    //유저가 가지고 있는 권한 목록 조회
    @GetMapping("/list/me")
    public ResponseEntity<AuthInfoListResponse> getAuthList(@RequestHeader String userId, @RequestParam(required = false, defaultValue = "0")int limit, @RequestParam(required = false, defaultValue = "0")int offset, @RequestParam(required = false, defaultValue = "0")int order){
        AuthInfoListResponse authList;

        authList = authUserService.getAuthList(userId, limit, offset, order);


        return ResponseEntity.ok().body(authList);
    }

}
