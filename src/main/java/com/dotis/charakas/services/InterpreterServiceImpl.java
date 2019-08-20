package com.dotis.charakas.services;

import java.util.*;
import java.util.function.*;
import com.dotis.charakas.actions.*;

public class InterpreterServiceImpl implements InterpreterService {
    final public Map<String, Function<List<String>, ActionPayload>> commandsToCreators = new HashMap<>() {{
        put("project create", ProjectActionsFactory::createProject);
        put("project select", ProjectActionsFactory::selectProject);
    }};

    public ActionPayload interpret() {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();

        StringTokenizer st = new StringTokenizer(line);
        List<String> tokens = new ArrayList<>();

        while (st.hasMoreTokens()) {
            tokens.add(st.nextToken());
        }

        return createPayload(tokens);
    }

    protected ActionPayload createPayload(List<String> tokens) {
        String input = String.join(" ", tokens).toLowerCase();
        
        BiFunction<String, Function<List<String>, ActionPayload>, ActionPayload> tryCreatePayload = (cmd, creator) -> {
            if (input.startsWith(cmd))
                return creator(tokens);

            return null;
        };

        for (var commandToCreator : commandsToCreators) {
            var payload = tryCreatePayload(commandToCreator.getKey(), commandToCreator.getValue());

            if (payload != null)
                return payload;
        }

        return new UnknownActionPayload();
    }
}