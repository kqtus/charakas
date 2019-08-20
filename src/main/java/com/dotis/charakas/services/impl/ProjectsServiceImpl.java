package com.dotis.charakas.services.impl;

import java.util.List;
import java.util.LinkedList;
import com.dotis.charakas.actions.*;
import com.dotis.charakas.models.*;
import com.dotis.charakas.services.ProjectsService;

public class ProjectsServiceImpl implements ProjectsService {
    private List<Project> projects = new LinkedList<>();

    public List<Project> getProjects() {
        return projects;
    }

    public boolean addProject(CreateProjectPayload payload) {
        return projects.add(new Project(
            payload.getProjectName()
        ));
    }
} 