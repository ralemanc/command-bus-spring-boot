package com.emedina.command.spring.handler;

import com.emedina.command.spring.command.UpperCaseCommand;
import com.emedina.sharedkernel.command.core.CommandHandler;

public class UpperCaseHandler implements CommandHandler<UpperCaseCommand> {

    @Override
    public void handle(final UpperCaseCommand command) {

        System.out.print(command.text().toUpperCase());
    }
}
