package org.envycorp.ticketservice.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Configurator {
    @Bean
    public ModelMapper MapperService() {
        return new ModelMapper();
    }
}
