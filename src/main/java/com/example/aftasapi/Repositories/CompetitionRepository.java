package com.example.aftasapi.Repositories;

import com.example.aftasapi.Entities.CompetitionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompetitionRepository extends JpaRepository<CompetitionEntity,Long> {
}
