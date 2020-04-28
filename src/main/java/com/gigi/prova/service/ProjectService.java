package com.gigi.prova.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gigi.prova.domain.Project;
import com.gigi.prova.repository.ProjectRepository;

@Service
public class ProjectService {
    @Autowired
    private ProjectRepository projectRepository;

    public Project save(Project project){
        return projectRepository.save(project);
    }

    public Project findById(Long id){
        return projectRepository
                .findById(id)
                .orElseThrow(NoSuchElementException::new);
    }

    public List<Project> findAll(){
        return projectRepository.findAll();
    }

    public void deleteById(Long id) {
        projectRepository.deleteById(id);
    }
}
