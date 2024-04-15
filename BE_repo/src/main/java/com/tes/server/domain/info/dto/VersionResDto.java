package com.tes.server.domain.info.dto;

import lombok.Getter;

@Getter
public class VersionResDto {

    // 서비스 버전
    private String serviceVersion;

    public VersionResDto() {
        this.serviceVersion = "1.0.0";
    }
}
