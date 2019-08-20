package com.dotis.charakas;

import com.dotis.charakas.actions.*;
import com.dotis.charakas.services.*;


public class Host {
    private InterpreterService interpreter;
    private ProjectsService projectsSrv;
    private ProvidersService providersSrv;

    public Host(InterpreterService interpreter) {
        this.interpreter = interpreter;
    }

    public void run() {
        while (true) {
            ActionPayload payload = interpreter.interpret();
            dispatch(payload);
        }
    }

    protected void dispatch(ActionPayload payload) {
        if (payload instanceof CreateProjectPayload) {
            return;
        }
    }
}