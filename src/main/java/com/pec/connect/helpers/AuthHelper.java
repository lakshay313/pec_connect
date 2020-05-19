package com.pec.connect.helpers;

import com.pec.connect.services.IdentityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Base64;

@Component
public class AuthHelper {

    @Value("${service.app-secret}")
    private String appSecret;

    @Autowired
    IdentityService identityService;

    public boolean validateToken(String accessToken) {
        String token = new String(Base64.getDecoder().decode(accessToken));
        String[] value = token.split(":");

        try {
            if (value[0].equals(appSecret)) {
                return identityService.verifyUser(Long.parseLong(value[1]), value[2]);
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }
}
