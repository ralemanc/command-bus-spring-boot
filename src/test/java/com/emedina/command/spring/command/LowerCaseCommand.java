package com.emedina.command.spring.command;

import com.emedina.sharedkernel.command.Command;


public record LowerCaseCommand (String text) implements Command {

}
