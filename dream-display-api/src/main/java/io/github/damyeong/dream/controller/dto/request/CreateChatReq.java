package io.github.damyeong.dream.controller.dto.request;

import lombok.Builder;

@Builder(toBuilder = true)
public record CreateChatReq(

    String content
) {
}
