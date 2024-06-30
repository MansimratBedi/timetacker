package com.example.timetacker.controllers;

import com.example.timetacker.model.Task;
import com.example.timetacker.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable Long id) {
        Optional<Task> task = taskService.getTaskById(id);
        return task.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Task createTask(@RequestBody Task task) {
        return taskService.createTask(task);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask( @RequestBody Task taskDetails) {
        return ResponseEntity.ok(taskService.updateTask(taskDetails));
    }

    @GetMapping("/user/{user}")
    public ResponseEntity<List<Task>> getAllTasksByUser(@PathVariable String user) {
        List<Task> tasks = taskService.getAllTasksByUser(user);
        return ResponseEntity.ok(tasks);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable List<Long> ids) {
        taskService.deleteTask(ids);
        return ResponseEntity.noContent().build();
    }
}
