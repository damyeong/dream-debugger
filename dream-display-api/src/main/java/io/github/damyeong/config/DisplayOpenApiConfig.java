package io.github.damyeong.config;

import static org.springdoc.core.utils.Constants.SPRINGDOC_ENABLED;

import io.swagger.v3.core.jackson.ModelResolver;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
@ConditionalOnProperty(value = SPRINGDOC_ENABLED, havingValue = "true", matchIfMissing = true)
@ConditionalOnWebApplication
public class DisplayOpenApiConfig {

    static {
        ModelResolver.enumsAsRef = true;
    }

    // Todo. 재정의
    @Bean
    public OpenAPI displayOpenApi() {
        return new OpenAPI()
            .info(new Info()
                .title("dream-debugger display API")
                .description("REST API 문서입니다.")
                .version("v1.0.0")
            );
    }
}
