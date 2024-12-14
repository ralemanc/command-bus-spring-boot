package com.emedina.command.spring;

import com.emedina.command.spring.handler.LowerCaseHandler;
import com.emedina.command.spring.handler.UpperCaseHandler;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringCommandBusConfiguration {

    @Bean
    Registry registry(final ApplicationContext applicationContext) {
            return new Registry(applicationContext);
    }

    @Bean
    SpringCommandBus springCommandBus(final Registry registry) {
        return new SpringCommandBus(registry);
    }

    @Bean
    LowerCaseHandler lowerCaseHandler() {
        return new LowerCaseHandler();
    }

    @Bean
    UpperCaseHandler upperCaseHandler() {
        return new UpperCaseHandler();
    }
}
