package com.example.timetacker.service;


import com.example.timetacker.model.Task;
import com.example.timetacker.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public List<Task> getAllTasksByUser(String user) {
        return taskRepository.findAllByUser(user);
    }

    public Optional<Task> getTaskById(Long id) {
        return taskRepository.findById(id);
    }

    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    public Task updateTask(Task taskDetails) {
        return taskRepository.save(taskDetails);
    }

    public void deleteTask(List<Long> ids) {
        taskRepository.deleteAllById(ids);
    }
}
