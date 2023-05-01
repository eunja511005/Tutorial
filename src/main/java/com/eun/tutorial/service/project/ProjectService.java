package com.eun.tutorial.service.project;

import java.util.Map;

import com.eun.tutorial.dto.project.ProjectDTO;
import com.eun.tutorial.dto.project.ProjectListRequest;
import com.eun.tutorial.dto.project.ProjectListResponse;

public interface ProjectService {
    ProjectListResponse getProjects(ProjectListRequest request);
	Map<String, Object> createProject(ProjectDTO project);
	ProjectDTO getProjectById(String id);
}

