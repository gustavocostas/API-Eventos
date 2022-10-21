package br.com.db.ingressos.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    private String apiVersion = "v1";

    @Bean
    public OpenAPI openApiSpec(){
        return new OpenAPI().info(
                new Info()
                        .title("Eventos API")
                        .description("API com requisições do projeto Eventos.")
                        .version(this.apiVersion));
    }
}
