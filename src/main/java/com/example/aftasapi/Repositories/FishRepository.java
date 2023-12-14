package com.example.aftasapi.Repositories;

import com.example.aftasapi.Entities.FishEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FishRepository extends JpaRepository<FishEntity,Long> {
}
