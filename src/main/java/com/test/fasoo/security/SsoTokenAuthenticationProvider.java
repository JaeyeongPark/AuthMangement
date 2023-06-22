package com.test.fasoo.security;

import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.server.resource.BearerTokenAuthenticationToken;

import java.util.LinkedList;
import java.util.List;

public class SsoTokenAuthenticationProvider {

//    private final UserRoleService userRoleService;

    @Value("role-prefix")
    String rolePrefix;


    @Value("${secret-key}")
    private String secretKey;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {


        try{
            String subject = Jwts.parser().setSigningKey(secretKey)
                    .parseClaimsJws(authentication.getPrincipal().toString())
                    .getBody()
                    .getSubject();

            // 임시 역할 조회 START
            List<SimpleGrantedAuthority> authorities = new LinkedList<>();

//            UserRoleResponse userRole = userRoleService.findUserRoleByUserId(subject);
//            if(userRole != null){
//                authorities.add(new SimpleGrantedAuthority(rolePrefix + userRole.getAdminTypeId()));
//            }

            // 임시 역할 조회 END

            return new UsernamePasswordAuthenticationToken(subject, null, authorities);

        }catch (Exception e){
            return null;
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return BearerTokenAuthenticationToken.class.isAssignableFrom(authentication);
    }
}
