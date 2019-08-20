package com.dotis.charakas.services;

import java.util.*;
import com.dotis.charakas.actions.*;
import com.dotis.charakas.models.*;

public class ProjectsService {
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