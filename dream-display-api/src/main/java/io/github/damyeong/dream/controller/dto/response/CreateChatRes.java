package io.github.damyeong.dream.controller.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

@Schema(title = "꿈 해몽 응답")
@Builder(toBuilder = true)
public record CreateChatRes(

    @Schema(title = "꿈 해몽")
    String response
) {
}
