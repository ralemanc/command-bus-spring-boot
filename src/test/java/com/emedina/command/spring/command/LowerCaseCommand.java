package com.emedina.command.spring.command;

import com.emedina.sharedkernel.command.Command;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class LowerCaseCommand implements Command {

    private String text;
}
