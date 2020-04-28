package com.gigi.prova.service;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gigi.prova.domain.Task;
import com.gigi.prova.dto.TaskDto;
import com.gigi.prova.repository.TaskRepository;


@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    public Task save(Task task){
        return taskRepository.save(task);
    }

    public Task findById(Long id){
        return taskRepository
                .findById(id)
                .orElseThrow(NoSuchElementException::new);
    }

    public void deleteById(Long id) {
        taskRepository.deleteById(id);
    }
    
    public List<TaskDto> findAll(){
        List<Task> tasks = taskRepository.findAll();
        return criarDTO(tasks);
    }
    
    public List<TaskDto> findByStartDateGreaterThanEqualAndEndDateLessThanEqual(LocalDate startDate, LocalDate endDate){
        List<Task> tasks = taskRepository.findByStartDateGreaterThanEqualAndEndDateLessThanEqual(startDate, endDate);
        return criarDTO(tasks);
    }

    public List<TaskDto> findByStartDateGreaterThanEqualAndEndDateLessThanEqualAndStatusIs(LocalDate startDate, LocalDate endDate, Long status) {
        List<Task> tasks = taskRepository.findByStartDateGreaterThanEqualAndEndDateLessThanEqualAndStatusIs(startDate, endDate,status);
        return criarDTO(tasks);
    }

    public List<TaskDto> findByStatus(Long status){
        List<Task> tasks = taskRepository.findByStatus(status);
        return criarDTO(tasks);
    }

    private List<TaskDto> criarDTO(List<Task> tasks) {
        return tasks.stream().map(task -> new TaskDto(task.getId(), task.getStartDate(), task.getEndDate(), task.getStatus(),task.getTitle(),task.getDescription(),task.getTaskPoints())).collect(Collectors.toList());
    }
}
