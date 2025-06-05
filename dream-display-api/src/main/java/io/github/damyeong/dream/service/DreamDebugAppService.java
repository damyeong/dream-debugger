package io.github.damyeong.dream.service;

import io.github.damyeong.dream.controller.dto.request.CreateChatReq;
import io.github.damyeong.dream.controller.dto.response.CreateChatRes;
import io.github.damyeong.dream.service.prompt.DreamDebugPrompt;
import io.github.damyeong.openai.protocol.ChatCompletionReq;
import io.github.damyeong.openai.service.OpenAiClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DreamDebugAppService {

    private final OpenAiClient openAiClient;

    public CreateChatRes getChatCompletion(CreateChatReq req) {
        // Todo. validation 추가 필요
        // Todo. DreamDebugPrompt.INSTRUCTION 상수화. 혹은 properties 로 관리
        // Todo. Prompt Injection 방지
        var dreamAnalysis = openAiClient.getChatCompletion(ChatCompletionReq.builder()
            .instruction(DreamDebugPrompt.INSTRUCTION)
            .userInput(req.content())
            .build());

        return new CreateChatRes(dreamAnalysis);
    }
}
