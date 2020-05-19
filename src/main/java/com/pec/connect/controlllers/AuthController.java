package com.pec.connect.controlllers;

import com.pec.connect.dto.LoginRequest;
import com.pec.connect.dto.LoginResponse;
import com.pec.connect.entity.Identity;
import com.pec.connect.exceptions.AuthenticationFailedException;
import com.pec.connect.exceptions.IdentityNotFoundException;
import com.pec.connect.helpers.AuthHelper;
import com.pec.connect.services.IdentityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class AuthController {

    @Autowired IdentityService identityService;

    @Autowired AuthHelper authHelper;

    @PostMapping("/login")
    public LoginResponse login(@Valid @RequestBody LoginRequest loginRequest) throws IdentityNotFoundException {
        return identityService.login(loginRequest.getUid(), loginRequest.getPassword());
    }

    @PostMapping("/create-user")
    public Identity createUser(@RequestBody Identity identityRequest) {
        return identityService.createUser(identityRequest);
    }

    @PostMapping("/access")
    public Object getAccess(@RequestHeader(name = "access_token") String token) throws AuthenticationFailedException {
        if (authHelper.validateToken(token))
            return identityService.getAccess(token);
        else
            throw new AuthenticationFailedException("Invalid Access Token");
    }


}
