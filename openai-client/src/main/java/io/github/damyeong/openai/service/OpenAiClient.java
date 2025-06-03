package io.github.damyeong.openai.service;

import io.github.damyeong.openai.protocol.ChatCompletionReq;

public interface OpenAiClient {

    // Todo. add comments
    String getChatCompletion(ChatCompletionReq req);
}
