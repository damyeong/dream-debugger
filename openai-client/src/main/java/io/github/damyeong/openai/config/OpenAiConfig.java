package io.github.damyeong.openai.config;

import com.theokanning.openai.service.OpenAiService;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(OpenAiProperties.class)
public class OpenAiConfig {

    @Bean
    public OpenAiService openAiService(OpenAiProperties properties) {
        return new OpenAiService(properties.getApiKey());
    }
} 