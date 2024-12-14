package com.emedina.command.spring.handler;

import com.emedina.command.spring.command.LowerCaseCommand;
import com.emedina.sharedkernel.command.core.CommandHandler;

public class LowerCaseHandler implements CommandHandler<LowerCaseCommand> {

    @Override
    public void handle(final LowerCaseCommand command) {

        System.out.print(command.getText().toLowerCase());
    }
}
