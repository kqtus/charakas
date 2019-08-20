package com.dotis.charakas.actions;

import java.util.*;

public class ProjectActionsFactory {
    public static CreateProjectPayload createProject(List<String> arguments) {
        return new CreateProjectPayload("projectName");
    }

    public static ActionPayload selectProject(List<String> arguments) {
        return new CreateProjectPayload("projectName");
    }
}