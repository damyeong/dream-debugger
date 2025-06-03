package io.github.damyeong.openai.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties(prefix = "openai")
public class OpenAiProperties {
    
    /**
     * OpenAI API Key
     */
    private String apiKey;
    
    /**
     * Model to use for chat completion (default: gpt-3.5-turbo)
     */
    private String model;
    
    /**
     * Maximum tokens to generate
     */
    private Integer maxTokens;
    
    /**
     * Temperature for response generation (0.0 to 2.0)
     */
    private Double temperature;
    
    /**
     * API request timeout in seconds
     */
    private Integer timeoutSeconds;
} 