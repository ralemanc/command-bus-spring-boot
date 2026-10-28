package com.emedina.command.spring;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.reflect.TypeUtils;
import com.emedina.sharedkernel.command.Command;
import com.emedina.sharedkernel.command.core.CommandHandler;

/**
 * A registry that holds the mapping between a command and its handler.
 *
 * @author Enrique Medina Montenegro
 * @see CommandHandler
 */
public final class Registry {

    private final Map<Class<? extends Command>, CommandHandler<? extends Command>> providerMap = new HashMap<>();

    /**
     * Constructor-based dependency injection.
     *
     * @param commandHandlers CommandHandlers list
     */
    public Registry(final List<CommandHandler<? extends Command>> commandHandlers) {
        for (final CommandHandler<? extends Command> commandHandler : commandHandlers) {
            final var types = TypeUtils.getTypeArguments(commandHandler.getClass(), CommandHandler.class);
            if (types == null || types.isEmpty()) {
                throw new IllegalStateException("Could not resolve command type for handler: " + commandHandler.getClass().getName());
            }
            final var commandType = (Class<? extends Command>) types.get(CommandHandler.class.getTypeParameters()[0]);
            this.providerMap.put(commandType, commandHandler);
        }
    }


    @SuppressWarnings("unchecked")
    <C extends Command> CommandHandler<C> get(final Class<C> commandClass) {
        return (CommandHandler<C>) this.providerMap.get(commandClass);
    }

}
