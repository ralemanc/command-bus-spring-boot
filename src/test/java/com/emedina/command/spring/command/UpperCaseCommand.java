package com.emedina.command.spring.command;

import com.emedina.sharedkernel.command.Command;

public record UpperCaseCommand (String text) implements Command {

}
