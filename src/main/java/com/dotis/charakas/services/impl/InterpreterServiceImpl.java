package com.dotis.charakas.services.impl;

import java.util.*;
import java.util.function.*;
import com.dotis.charakas.actions.*;
import com.dotis.charakas.services.InterpreterService;

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
        
        BiFunction<String, Function<List<String>, ActionPayload>, ActionPayload> tryCreatePayload = (String cmd, Function<List<String>, ActionPayload> creator) -> {
            if (input.startsWith(cmd)) {
                return creator.apply(tokens);
            }
            
            return null;
        };

        
        for (var commandToCreator : commandsToCreators.entrySet()) {
            var payload = tryCreatePayload.apply(commandToCreator.getKey(), commandToCreator.getValue());

            if (payload != null) {
                return payload;
            }
        }
        
        return new UnknownActionPayload();
    }
}