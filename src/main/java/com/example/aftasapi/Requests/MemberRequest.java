package com.example.aftasapi.Requests;

import com.example.aftasapi.DTOs.HuntingDTO;
import com.example.aftasapi.DTOs.RankingDTO;
import com.example.aftasapi.Enums.IdentityDocumentType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberRequest {
    @NotNull(message = "Name cannot be null")
    @NotBlank(message = "Name cannot be blank")
    private String name ;
    @NotNull(message = "familyName cannot be null")
    @NotBlank(message = "familyName cannot be blank")
    private String familyName ;
    @NotNull(message = "Date cannot be null")
    private Date accessionDate ;
    @NotNull(message = "nationality cannot be null")
    @NotBlank(message = "nationality cannot be blank")
    private String nationality ;
    @NotNull(message = "identityDocument cannot be null")
    @NotBlank(message = "identityDocument cannot be blank")
    private IdentityDocumentType identityDocument ;
    @NotNull(message = "identityNumber cannot be null")
    @NotBlank(message = "identityNumber cannot be blank")
    private String identityNumber ;

}
