package com.example.aftasapi.Helpers;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class ErrorMessage {
    private Date timeStamp ;
    private String message ;

}
