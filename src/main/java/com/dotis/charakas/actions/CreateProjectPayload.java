package com.dotis.charakas.actions;

public class CreateProjectPayload extends ActionPayload {
    private String projectName;

    public CreateProjectPayload(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectName() {
        return projectName;
    }
}