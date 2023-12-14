package com.example.aftasapi.Repositories;

import com.example.aftasapi.Entities.CompetitionEntity;
import com.example.aftasapi.Entities.HuntingEntity;
import com.example.aftasapi.Entities.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface HuntingRepository extends JpaRepository<HuntingEntity,Long> {

    Optional<HuntingEntity> findById(Long id);
    Optional<HuntingEntity> findByCompetitionAndMember(CompetitionEntity competition , MemberEntity member);
}
