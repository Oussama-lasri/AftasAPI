package com.example.aftasapi.DTOs.Requests;

import com.example.aftasapi.Enums.IdentityDocumentType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberRequest {
    @NotBlank(message = "Name is required")
    private String name ;
    @NotBlank(message = "Family name is required")
    private String familyName ;
    @Past(message = "Accession date must be in the past")
    private Date accessionDate ;
    @NotBlank(message = "Nationality is required")
    private String nationality ;
    @NotNull(message = "Identity document type is required")
    private IdentityDocumentType identityDocument ;
    @NotBlank(message = "Identity number is required")
    @Size(min = 1, max = 20, message = "Identity number must be between 1 and 20 characters")
    private String identityNumber ;
}
