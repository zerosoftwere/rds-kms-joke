package ng.zerosoft.joke.config

import io.swagger.v3.oas.models.ExternalDocumentation
import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class OpenApiConfig {

    @Bean
    fun customOpenAPI(): OpenAPI = OpenAPI()
        .info(
            Info()
                .title("Joke API")
                .description("Simple API to manage jokes")
                .version("1.0.0")
        )
        .externalDocs(ExternalDocumentation().description("Joke API Docs"))
}
