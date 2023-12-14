package com.example.aftasapi.Repositories;

import com.example.aftasapi.Entities.RankingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RankingRepository extends JpaRepository<RankingEntity,Long> {
}
