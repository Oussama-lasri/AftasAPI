package com.example.aftasapi.Repositories;

import com.example.aftasapi.Entities.FishEntity;
import com.example.aftasapi.Entities.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<MemberEntity,Long> {

    public Optional<MemberEntity> findByNum(long num);
}
