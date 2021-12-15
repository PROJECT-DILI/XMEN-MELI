package com.project.xmen.api.configuration;

import com.project.xmen.application.Service.MutanService;
import com.project.xmen.application.Service.StatsService;
import com.project.xmen.persistence.AdnRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Bean
    public MutanService mutantsService() {
        return new MutanService();
    }

    @Bean
    public StatsService statsService() {
        return new StatsService();
    }

    @Bean
    public AdnRepository dnaTypeService () {
        return  new AdnRepository();
    }





}
