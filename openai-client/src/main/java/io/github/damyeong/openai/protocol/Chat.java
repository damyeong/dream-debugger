package io.github.damyeong.openai.protocol;

import lombok.Builder;

@Builder
public record Chat(

    Role role,
    String content
) {

}
