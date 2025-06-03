package io.github.damyeong.dream.service;

import io.github.damyeong.dream.controller.dto.request.CreateChatReq;
import io.github.damyeong.dream.service.prompt.DreamDebugPrompt;
import io.github.damyeong.openai.protocol.ChatCompletionReq;
import io.github.damyeong.openai.service.OpenAiClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DreamDebugAppService {

    private final OpenAiClient openAiClient;

    public String getChatCompletion(CreateChatReq req) {
        return openAiClient.getChatCompletion(ChatCompletionReq.builder()
            .instruction(DreamDebugPrompt.INSTRUCTION)
            .userInput(req.content())
            .build());
    }
}
