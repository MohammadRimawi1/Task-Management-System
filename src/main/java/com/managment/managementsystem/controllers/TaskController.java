package com.managment.managementsystem.controllers;

import com.managment.managementsystem.models.Task;
import com.managment.managementsystem.services.TaskServices;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tasks")
public class TaskController {
    private final TaskServices taskServices;

    public TaskController(TaskServices taskServices) {
        this.taskServices = taskServices;
    }

    @GetMapping
    public List<Task> getAllTasks() {
        return taskServices.getAllTasks();
    }

    @GetMapping("/status")
    public List<Task> getTasksByStatus(@RequestParam boolean completed) {
        return taskServices.getTasksByStatus(completed);
    }

    @PostMapping
    public Task createTask(@RequestBody Task task, @RequestParam Long categoryId) {
        return taskServices.createTask(task, categoryId);
    }

    @PatchMapping("/{id}/toggle")
    public Task toggleTask(@PathVariable Long id) {
        return taskServices.toggleTaskStatus(id);
    }
}
