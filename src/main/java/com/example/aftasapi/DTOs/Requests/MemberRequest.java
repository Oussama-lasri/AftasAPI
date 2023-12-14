package com.example.aftasapi.DTOs.Requests;

import com.example.aftasapi.Enums.IdentityDocumentType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberRequest {
    private String name ;
    private String familyName ;
    private Date accessionDate ;
    private String nationality ;
    private IdentityDocumentType identityDocument ;
    private String identityNumber ;

}
