package io.github.damyeong.openai.protocol;

import lombok.Builder;

@Builder(toBuilder = true)
public record ChatCompletionReq(

    String instruction,
    String userInput
) {
}
