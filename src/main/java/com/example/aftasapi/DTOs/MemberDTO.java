package com.example.aftasapi.DTOs;

import com.example.aftasapi.Entities.HuntingEntity;
import com.example.aftasapi.Entities.RankingEntity;
import com.example.aftasapi.Enums.IdentityDocumentType;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Date;
import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MemberDTO {

    private long num ;

    private String name ;

    private String familyName ;
    private Date accessionDate ;
    private String nationality ;
    private IdentityDocumentType identityDocument ;

    private String identityNumber ;
    @JsonManagedReference
    private List<HuntingDTO> huntingList ;
    @JsonManagedReference
    private List<RankingDTO> rankingList ;
}
