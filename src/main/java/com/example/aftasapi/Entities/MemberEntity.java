package com.example.aftasapi.Entities;

import com.example.aftasapi.Enums.IdentityDocumentType;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "members")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MemberEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long num ;

    @Column(nullable = false)
    private String name ;

    @Column(nullable = false)
    private String familyName ;

    @Column(nullable = false)
    @CreationTimestamp
    private Date accessionDate ;

    @Column(nullable = false)
    private String nationality ;


    @Column(nullable = false)
    private IdentityDocumentType identityDocument ;

    @Column(nullable = false)
    private String identityNumber ;

    @OneToMany(mappedBy = "member",fetch = FetchType.LAZY ,cascade = CascadeType.ALL)

    private List<HuntingEntity> huntingList ;

//    @ManyToMany
//    @JoinTable(name = "rankings",
//            joinColumns = @JoinColumn(name = "members_id"),
//            inverseJoinColumns = @JoinColumn(name = "competitions_id"))
//    private List<CompetitionEntity> competitions ;

    @OneToMany(mappedBy = "member" , fetch = FetchType.LAZY)
    private List<RankingEntity> rankingList ;


}
