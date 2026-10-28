package com.emedina.command.spring;

import com.emedina.sharedkernel.command.Command;
import com.emedina.sharedkernel.command.core.CommandBus;
import com.emedina.sharedkernel.command.core.CommandHandler;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;

import java.util.List;

@AutoConfiguration
public class CommandBusConfiguration {

    @Bean
    @ConditionalOnMissingBean
    CommandBus commandBus(final List<CommandHandler<? extends Command>> commandHandlers) {
        return new SpringCommandBus(new Registry(commandHandlers));
    }
}
