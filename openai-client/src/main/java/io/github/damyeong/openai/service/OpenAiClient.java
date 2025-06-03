package io.github.damyeong.openai.service;

public interface OpenAiClient {

    String getChatCompletion(String prompt);
}
