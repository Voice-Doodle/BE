package com.tes.server.domain.vodle.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
public class VoiceSampleResDto {

    private String voiceType;
    private String voiceTypeKr;
    private String url;

    @Builder
    public VoiceSampleResDto(String voiceType, String voiceTypeKr,String url) {
        this.voiceType = voiceType;
        this.voiceTypeKr = voiceTypeKr;
        this.url = url;
    }
}
