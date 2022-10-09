package com.example.java_login_tutorial.registration;

import com.example.java_login_tutorial.appuser.AppUser;
import com.example.java_login_tutorial.appuser.AppUserRole;
import com.example.java_login_tutorial.appuser.AppUserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class RegistrationService {

    private final AppUserService appUserService;
    private EmailValidator emailValidator;

    public String register(RegistrationRequest request) {
        boolean isValid = emailValidator.test(request.getEmail());

        if(!isValid){
            throw new IllegalStateException("Email not valid");
        }

        return appUserService.signUpUser(
                new AppUser(
                        request.getFirstName(),
                        request.getLastName(),
                        request.getEmail(),
                        request.getPassword(),
                        AppUserRole.USER
                )
        );
    }
}
