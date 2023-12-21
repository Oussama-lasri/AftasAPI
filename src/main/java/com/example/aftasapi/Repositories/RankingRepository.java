package com.example.aftasapi.Repositories;

import com.example.aftasapi.DTOs.RankingDTO;
import com.example.aftasapi.Entities.CompetitionEntity;
import com.example.aftasapi.Entities.MemberEntity;
import com.example.aftasapi.Entities.RankingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RankingRepository extends JpaRepository<RankingEntity,Long> {
    public Optional<RankingEntity> findByCompetitionAndMember(CompetitionEntity competition , MemberEntity member);

    List<RankingEntity> findByCompetition(CompetitionEntity competition);
}
