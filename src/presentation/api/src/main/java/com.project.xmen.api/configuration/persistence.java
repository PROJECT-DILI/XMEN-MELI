package com.project.xmen.api.configuration;

import com.project.xmen.persistence.configuration.AppConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class persistence {

    @Bean
    public AppConfig appConfig(){
        return new AppConfig();
    }

}
