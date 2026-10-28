package com.emedina.command.spring;

import com.emedina.sharedkernel.command.core.CommandBus;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@AutoConfiguration
public class CommandBusConfiguration {

    @Bean
    @ConditionalOnMissingBean
    CommandBus commandBus(final ApplicationContext applicationContext) {
        return new SpringCommandBus(new Registry(applicationContext));
    }
}
