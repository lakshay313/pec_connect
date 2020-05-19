package com.pec.connect.services;

import com.pec.connect.dto.LoginResponse;
import com.pec.connect.entity.Identity;
import com.pec.connect.exceptions.IdentityNotFoundException;

public interface IdentityService {

    LoginResponse login(String email, String password) throws IdentityNotFoundException;

    Identity createUser(Identity identityRequest);

    Object getAccess(String token);

    boolean verifyUser(Long id, String email);

    Identity getUserById(Long uid);
}
