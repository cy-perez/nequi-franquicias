package nequi.franquicias.config;

import nequi.franquicias.domain.common.FranquiciaGatewayRepository;
import nequi.franquicias.domain.common.SucursalGatewayRepository;
import nequi.franquicias.service.FranquiciaService;
import nequi.franquicias.service.SucursalService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfig {

    @Bean
    public FranquiciaService franquiciaService(FranquiciaGatewayRepository franquiciaGatewayRepository){
        return new FranquiciaService(franquiciaGatewayRepository);
    }

    @Bean
    public SucursalService sucursalService(SucursalGatewayRepository sucursalGatewayRepository){
        return new SucursalService(sucursalGatewayRepository);
    }
}
