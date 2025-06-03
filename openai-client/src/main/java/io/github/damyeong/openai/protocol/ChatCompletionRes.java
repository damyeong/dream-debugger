package io.github.damyeong.openai.protocol;

import java.util.List;
import lombok.Builder;

@Builder(toBuilder = true)
public record ChatCompletionRes(

    List<Choice> choices
) {

    public record Choice(
        Message message
    ) {
    }

    public record Message(
        String role,
        String content
    ) {
    }

    public String getFirstMessageContent() {
        return choices.getFirst().message.content;
    }
}