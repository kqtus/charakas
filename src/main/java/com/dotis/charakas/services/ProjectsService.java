package com.dotis.charakas.services;

import java.util.List;
import com.dotis.charakas.actions.*;
import com.dotis.charakas.models.*;

public interface ProjectsService {
    List<Project> getProjects();

    boolean addProject(CreateProjectPayload payload);
}