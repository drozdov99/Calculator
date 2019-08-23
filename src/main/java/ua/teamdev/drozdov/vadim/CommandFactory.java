package ua.teamdev.drozdov.vadim;

import ua.teamdev.drozdov.vadim.command.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class CommandFactory {

    private final Map<String, Command> registry = new HashMap<String, Command>() {{
        put("+", new AddCommand());
        put("-", new SubtractCommand());
        put("*", new MultiplyCommand());
        put("/", new DivideCommand());
    }};

    public Command create(String operatorPresentation) {
        return registry.get(operatorPresentation);
    }

    public Set<String> getAvailableOperatorPresentations() {
        return registry.keySet();
    }
}
