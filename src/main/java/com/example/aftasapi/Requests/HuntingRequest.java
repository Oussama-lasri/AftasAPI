package com.example.aftasapi.Requests;

import lombok.Data;

@Data
public class HuntingRequest {
    private int numberOfFish ;

    private long fish_id ;

    private String competition_code ;

    private long member_num ;
}
