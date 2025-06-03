package io.github.damyeong.openai.service;

import com.theokanning.openai.completion.chat.ChatCompletionRequest;
import com.theokanning.openai.completion.chat.ChatMessage;
import com.theokanning.openai.service.OpenAiService;
import io.github.damyeong.openai.config.OpenAiProperties;
import io.github.damyeong.openai.exception.OpenAiException;
import io.github.damyeong.openai.protocol.ChatCompletionReq;
import io.github.damyeong.openai.protocol.ChatCompletionRes;
import io.github.damyeong.openai.protocol.Chat;
import io.github.damyeong.openai.protocol.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class OpenAiClientImpl implements OpenAiClient {

    private final OpenAiProperties properties;
    private final OpenAiService service;

    @Override
    public String getChatCompletion(ChatCompletionReq req) {
        List<Chat> messages = new ArrayList<>();
        messages.add(new Chat(Role.SYSTEM, req.instruction()));
        messages.add(new Chat(Role.USER, req.userInput()));

        return createChatCompletion(messages).getFirstMessageContent();
    }

    private ChatCompletionRes createChatCompletion(List<Chat> messages) {
        try {
            var openAiRequest = ChatCompletionRequest.builder()
                .model(properties.getModel())
                .messages(convertToOpenAiMessages(messages))
                .temperature(properties.getTemperature())
                .build();

            var openAiResponse = service.createChatCompletion(openAiRequest);
            
            return ChatCompletionRes.builder()
                    .choices(List.of(new ChatCompletionRes.Choice(
                        new ChatCompletionRes.Message(
                            openAiResponse.getChoices().getFirst().getMessage().getRole(),
                            openAiResponse.getChoices().getFirst().getMessage().getContent()
                        )
                    )))
                    .build();

        } catch (Exception e) {
            log.error("Failed to get chat completion", e);
            throw new OpenAiException("Failed to get chat completion", e);
        }
    }

    private List<ChatMessage> convertToOpenAiMessages(List<Chat> messages) {
        return messages.stream()
                .map(msg -> new ChatMessage(
                    msg.role().getValue(),
                    msg.content()
                ))
                .toList();
    }
}