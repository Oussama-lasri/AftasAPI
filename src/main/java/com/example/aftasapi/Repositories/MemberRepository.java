package com.example.aftasapi.Repositories;

import com.example.aftasapi.Entities.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<MemberEntity,Long> {
}
