package io.github.damyeong.openai.protocol;

import lombok.Builder;

@Builder(toBuilder = true)
public record ChatMessage(

    String role,
    String content
) {

}
