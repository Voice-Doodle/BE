package com.tes.server.domain.info.controller;

import com.tes.server.domain.info.dto.VersionResDto;
import com.tes.server.global.Base.DataResponseBody;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.TreeMap;

@Tag(name = "0. 정보", description = "앱 정보 API")
@RestController
@RequiredArgsConstructor
@RequestMapping("/info")
@Slf4j
public class InfoController {

    /**
     * 1. 앱 서비스 관련 정보 메서드
     *
     * 역할: 서비스에 대한 개인정보처리방침 및 서비스 이용약관이 있는 url을 던져준다.
     *
     * @return
     */
    @Operation(summary = "개인정보처리방침 및 서비스 이용약관 조회", description = "\n\n 사용자는 서비스 정책을 조회할 수 있다.")
    @GetMapping("/policy")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "ALL", description = "성공 \n\n Success 반환",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = DataResponseBody.class),
                            examples = {

                                    @ExampleObject(name = "조회 성공", description = "사용자는 조회를 통해 위와 같은 응답 데이터를 받는다.", value = """ 
                                        { 
                                            "status" : 200, 
                                            "message" : "정보 조회 성공",
                                            "code" : "SUCCESS",
                                            "data" : {
                                                "url": "https://호스트명/api명"
                                            }
                                        } 
                                    """)
                            })),
    })
    public ResponseEntity<?> getPolicy() {
        Map<String, Object> result = new TreeMap<>();
        result.put("data", "https://sites.google.com/view/vodle/%ED%99%88");

        return ResponseEntity.status(HttpStatus.OK).body(DataResponseBody.of(200, "정보 조회 성공", "SUCCESS", result));
    }


    @Operation(summary = "서비스 버전 확인", description = "\n\n사용자는 해당 서비스 버전 확인이 가능하다.")
    @GetMapping("")
    @ApiResponse(
            responseCode = "200", description = "성공 \n\n 서비스 버전 정보 반환",
            content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = DataResponseBody.class),
                    examples = {
                            @ExampleObject(name = "서비스 버전 확인 성공", description = "사용자는 서비스 버전 확인 요청을 통해 위와 같은 응답 데이터를 받는다.", value = """
                                    {
                                        "status": 200,
                                        "message": "서비스 버전 확인 완료",
                                        "code": "SUCCESS",
                                        "data": {
                                            "serviceVersion": "1.0.0"
                                        }   
                                    }
                                    """),
                            @ExampleObject(name = "서비스 버전 확인 실패", description = "사용자는 서비스 버전 확인 요청 실패시 위와 같은 응답 데이터를 받는다.", value = """
                                    {
                                        "status": 400,
                                        "message": "서비스 버전 확인 실패",
                                        "code": "F-001"
                                    }
                                    """),
                    })
    )
    public ResponseEntity<? extends DataResponseBody> getVersion() {

        log.info("서비스 버전 확인 URL 매핑 : {}", "OK");

        return ResponseEntity.status(HttpStatus.OK).body(DataResponseBody.of(200, "OK", "SUCCESS", new VersionResDto()));
    }
}