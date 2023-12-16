package com.example.aftasapi.Repositories;

import com.example.aftasapi.Entities.CompetitionEntity;
import com.example.aftasapi.Entities.FishEntity;
import com.example.aftasapi.Entities.HuntingEntity;
import com.example.aftasapi.Entities.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface HuntingRepository extends JpaRepository<HuntingEntity,Long> {

    Optional<HuntingEntity> findById(Long id);
    Optional<HuntingEntity> findByCompetitionAndMember(CompetitionEntity competition , MemberEntity member);
    List<HuntingEntity> findAllByCompetitionAndMember(CompetitionEntity competition , MemberEntity member);
    Optional<HuntingEntity> findByCompetitionAndMemberAndFish(CompetitionEntity competition , MemberEntity member, FishEntity fish);

    @Query("SELECT h FROM HuntingEntity h WHERE h.competition = :competition AND h.member = :member AND h.fish = :fish")
    List<HuntingEntity> findByCompetitionAndMemberAndFishSingleResult(
            @Param("competition") CompetitionEntity competition,
            @Param("member") MemberEntity member,
            @Param("fish") FishEntity fish
    );
}
