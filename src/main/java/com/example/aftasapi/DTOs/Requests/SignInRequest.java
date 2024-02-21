package com.example.aftasapi.DTOs.Requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

// log in
@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class SignInRequest {

    private String email ;
        private String password ;
}
