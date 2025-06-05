package io.github.damyeong.dream.controller.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

@Schema(title = "꿈 해몽 요청")
@Builder(toBuilder = true)
public record CreateChatReq(

    @Schema(title = "꿈 내용", description = "해몽을 요청할 꿈의 내용", example = "아끼던 노트북이 폭발했어.")
    String content
) {
}
