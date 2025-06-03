package io.github.damyeong.openai.service;

import com.theokanning.openai.completion.chat.ChatCompletionRequest;
import com.theokanning.openai.completion.chat.ChatMessage;
import com.theokanning.openai.service.OpenAiService;
import io.github.damyeong.openai.config.OpenAiProperties;
import io.github.damyeong.openai.exception.OpenAiException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class OpenAiClientImpl implements OpenAiClient {

    private final OpenAiProperties properties;
    private final OpenAiService service;

    @Override
    public String getChatCompletion(String prompt) {
        log.debug("Requesting chat completion with prompt: {}", prompt);
        try {
            var request = ChatCompletionRequest.builder()
                    .model(properties.getModel())
                    .messages(List.of(new ChatMessage("user", prompt)))
                    .maxTokens(properties.getMaxTokens())
                    .temperature(properties.getTemperature())
                    .build();

            String response = service.createChatCompletion(request)
                    .getChoices().getFirst()
                    .getMessage().getContent();
            log.debug("Received response from OpenAI API: {}", response);
            return response;

        } catch (Exception e) {
            log.error("Failed to get chat completion", e);
            throw new OpenAiException("Failed to get chat completion", e);
        }
    }
}