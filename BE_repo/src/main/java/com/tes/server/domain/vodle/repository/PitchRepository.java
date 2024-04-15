package com.tes.server.domain.vodle.repository;

import com.tes.server.domain.vodle.entity.PitchEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PitchRepository extends JpaRepository<PitchEntity, Long> {
    PitchEntity findByVoiceType(String VoiceType);

    List<PitchEntity> findAll();
}
