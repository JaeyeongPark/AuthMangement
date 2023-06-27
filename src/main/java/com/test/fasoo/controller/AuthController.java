package com.test.fasoo.controller;



import com.test.fasoo.dto.AuthUser.*;
import com.test.fasoo.dto.AuthUser.AuthIdDto;
import com.test.fasoo.service.AuthUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthUserService authUserService;

    //유저 권한 생성
    @PostMapping
    public ResponseEntity<AuthIdListResponse> createAuthUser(
            @RequestBody @Valid AuthUserRequest authUserRequest){
        return ResponseEntity.ok().body(authUserService.createAuthUser(authUserRequest));
    }

    //유저 권한 조회
    @GetMapping
    public ResponseEntity<AuthInfoDto> getAuthUser(
            @RequestParam String userId,
            @RequestParam String authTypeId,
            @RequestParam String resourceId){

        CheckAuthRequest checkAuthRequest = new CheckAuthRequest(userId, authTypeId, resourceId);
        return ResponseEntity.ok().body(authUserService.getAuthUser(checkAuthRequest));
    }

    //유저 권한 수정
    @PutMapping
    public ResponseEntity<List<AuthIdDto>> updateAuthUser(
            @RequestBody AuthUserRequest authUserRequest){
        return ResponseEntity.ok().body(authUserService.updateAuthUser(authUserRequest));
    }

    //유저 권한 삭제
    @DeleteMapping
    public ResponseEntity<Integer> deleteAuthUser(
            @RequestParam String userId,String authTypeName, String dataId){

        return ResponseEntity.ok().body(authUserService.deleteAuthUser(userId, authTypeName,dataId));
    }

    //관리자가 권한을 가지고 있는 유저 목록을 조회
    @GetMapping("/list")
    public ResponseEntity<AuthInfoListResponse> getUserList(
            @RequestHeader String userId
            , @RequestParam String authTypeName
            , @RequestParam(required = false, defaultValue = "0")int limit
            , @RequestParam(required = false, defaultValue = "0")int offset
            , @RequestParam(required = false, defaultValue = "0")int order) {
        return ResponseEntity.ok().body(authUserService.getUserList(userId, authTypeName, limit, offset, order));
    }

    //유저가 가지고 있는 권한 목록 조회
    @GetMapping("/list/me")
    public ResponseEntity<AuthInfoListResponse> getAuthList(
            @RequestHeader String userId
            ,@RequestParam(required = false, defaultValue = "0")int limit
            , @RequestParam(required = false, defaultValue = "0")int offset
            , @RequestParam(required = false, defaultValue = "0")int order){

        return ResponseEntity.ok().body(authUserService.getAuthList(userId, limit, offset, order));
    }

}
