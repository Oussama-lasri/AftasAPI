package com.example.aftasapi.Repositories;

import com.example.aftasapi.Entities.CompetitionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.Optional;

public interface CompetitionRepository extends JpaRepository<CompetitionEntity,Long> {

    public Optional<CompetitionEntity> findByDate(Date date);

    public Optional<CompetitionEntity> findByCode(String code);
}
