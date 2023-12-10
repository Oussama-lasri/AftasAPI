package com.example.aftasapi.Entities;

import com.example.aftasapi.Enums.IdentityDocumentType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "members")
@Data
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

    @OneToMany(mappedBy = "member",cascade = CascadeType.ALL)
    private List<HuntingEntity> huntingList ;

//    @ManyToMany
//    @JoinTable(name = "rankings",
//            joinColumns = @JoinColumn(name = "members_id"),
//            inverseJoinColumns = @JoinColumn(name = "competitions_id"))
//    private List<CompetitionEntity> competitions ;

    @OneToMany(mappedBy = "member")
    private List<RankingEntity> rankingList ;


}
