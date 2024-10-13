package nequi.franquicias.config;

import nequi.franquicias.domain.common.FranquiciaGatewayRepository;
import nequi.franquicias.service.FranquiciaService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfig {

    @Bean
    public FranquiciaService franquiciaService(FranquiciaGatewayRepository franquiciaGatewayRepository){
        return new FranquiciaService(franquiciaGatewayRepository);
    }
}
