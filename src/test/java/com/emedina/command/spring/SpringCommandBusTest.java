package com.emedina.command.spring;

import static org.assertj.core.api.Assertions.*;

import com.emedina.command.spring.command.LowerCaseCommand;
import com.emedina.command.spring.command.UpperCaseCommand;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

@SpringJUnitConfig
@ContextConfiguration(classes = SpringCommandBusConfiguration.class)
class SpringCommandBusTest {

    @Autowired
    SpringCommandBus commandBus;

    @Test
    void runLowerCaseCommand() {
        // Arrange
        final var lowerCaseCommand = LowerCaseCommand.builder().text("Spring TEST Command").build();

        final ByteArrayOutputStream myOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(myOut));

        // Act
        this.commandBus.execute(lowerCaseCommand);

        // Assert
        final String standardOutput = myOut.toString();
        assertThat(standardOutput).isEqualTo("spring test command");
    }

    @Test
    void runUpperCaseCommand() {
        // Arrange
        final var upperCaseCommand = UpperCaseCommand.builder().text("Spring TEST Command").build();
        final ByteArrayOutputStream myOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(myOut));

        // Act
        this.commandBus.execute(upperCaseCommand);

        // Assert
        final String standardOutput = myOut.toString();
        assertThat(standardOutput).isEqualTo("SPRING TEST COMMAND");
    }
}