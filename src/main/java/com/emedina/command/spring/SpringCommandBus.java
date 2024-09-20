package com.emedina.command.spring;

import com.emedina.sharedkernel.command.Command;
import com.emedina.sharedkernel.command.core.CommandBus;
import com.emedina.sharedkernel.command.core.CommandHandler;
import org.springframework.context.annotation.Bean;

/**
 * Implementation of a command bus backed by Spring's registry.
 *
 * @author Enrique Medina Montenegro (em54029)
 */
public class SpringCommandBus implements CommandBus {

    private final Registry registry;

    /**
     * Creates a new instance with the given registry using constructor-based dependency injection.
     *
     * @param registry a wrapper around Spring's application context
     */
    public SpringCommandBus(final Registry registry) {
        this.registry = registry;
    }

    /**
     * Delegates the handling of the command to the corresponding {@link Bean} from Spring.
     *
     * @param command the command object
     */
    @Override
    public <C extends Command> void execute(final C command) {
        CommandHandler<C> commandHandler = (CommandHandler<C>) this.registry.get(command.getClass());
        commandHandler.handle(command);
    }

}
