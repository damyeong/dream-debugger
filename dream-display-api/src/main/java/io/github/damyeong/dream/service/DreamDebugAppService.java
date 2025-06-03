package io.github.damyeong.dream.service;

import io.github.damyeong.dream.controller.dto.request.CreateChatReq;
import io.github.damyeong.openai.service.OpenAiClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DreamDebugAppService {

    private final OpenAiClient openAiClient;

    public String getChatCompletion(CreateChatReq req) {
        return openAiClient.getChatCompletion(req.prompt());
    }
}
