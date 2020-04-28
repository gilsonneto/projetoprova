package com.gigi.prova.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gigi.prova.domain.ProjectHistory;
import com.gigi.prova.repository.ProjectHistoryRepository;

@Service
public class ProjectHistoryService {
    @Autowired
    private ProjectHistoryRepository projectHistoryRepository;

    public ProjectHistory save(ProjectHistory projectHistory){
        return projectHistoryRepository.save(projectHistory);
    }

    public ProjectHistory findById(Long id){
        return projectHistoryRepository
                .findById(id)
                .orElseThrow(NoSuchElementException::new);
    }

    public List<ProjectHistory> findAll(){
        return projectHistoryRepository.findAll();
    }

    public void deleteById(Long id) {
        projectHistoryRepository.deleteById(id);
    }
}
