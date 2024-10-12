package nequi.franquicias.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI(){
        return new OpenAPI()
                .info(new Info()
                .title("Servicios de franquicias de Nequi")
                .version("0.1")
                .description("Documentación de APIs disponibles para administración de sucursales de Nequi")
                        .contact(new Contact()
                                .name("Cristhian Pérez")
                                .email("cristhian.dev@hotmail.com")));
    }
}
