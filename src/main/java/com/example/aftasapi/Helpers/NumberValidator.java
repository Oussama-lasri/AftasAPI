package com.example.aftasapi.Helpers;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Optional;
@Component
public class NumberValidator {
    public boolean isNonZeroNonNull(Long number){
        return Optional.ofNullable(number).orElse(0L) == 0 ;
    }

    public boolean isNonZeroNonNull(Integer number){
        return Optional.ofNullable(number).orElse(0) == 0 ;
    }
}
