package com.example.aftasapi.Services;

import com.example.aftasapi.DTOs.Requests.SignInRequest;
import com.example.aftasapi.DTOs.Requests.SignUpRequest;
import com.example.aftasapi.DTOs.Response.AuthenticationResponse;

public interface IAuthenticationService {

    // todo Sign in and sign up

    public AuthenticationResponse signIn(SignInRequest request);
    public AuthenticationResponse signUp(SignUpRequest request) throws Exception;
    public Boolean checkEmail(String email);

}
