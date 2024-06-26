package com.tes.server.domain.vodle.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
@Table(name = "pitch")
public class PitchEntity {
    @Id
    @Column(name = "pitch_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "voiceType", nullable = false, unique = true)
    private String voiceType;

    @Column(name = "voiceTypeKr", nullable = false, unique = true)
    private String voiceTypeKr;

    @Column(name = "male", nullable = false)
    private Integer male;

    @Column(name = "female", nullable = false)
    private Integer female;

    @Column(name = "url", nullable = false)
    private String url;
}
