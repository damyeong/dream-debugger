package io.github.damyeong.openai.protocol;

import java.util.List;
import lombok.Builder;

@Builder(toBuilder = true)
public record ChatCompletionRequest(

    String model,
    List<ChatMessage> messages,
    double temperature
) {
}