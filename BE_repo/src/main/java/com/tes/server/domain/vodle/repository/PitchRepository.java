package com.tes.server.domain.vodle.repository;

import com.tes.server.domain.vodle.entity.PitchEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PitchRepository extends JpaRepository<PitchEntity, Long> {
    PitchEntity findByVoiceType(String VoiceType);

    @Query("SELECT p.voiceType FROM PitchEntity p")
    List<String> findVoiceTypes();
    List<PitchEntity> findAll();
}
