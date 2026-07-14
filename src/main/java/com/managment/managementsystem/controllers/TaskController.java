package com.managment.managementsystem.controllers;

import com.managment.managementsystem.dto.ApiResponse;
import com.managment.managementsystem.models.Task;
import com.managment.managementsystem.services.TaskServices;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tasks")
public class TaskController {
    private final TaskServices taskServices;

    public TaskController(TaskServices taskServices) {
        this.taskServices = taskServices;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Task>> createTask(@Valid @RequestBody Task task, @RequestParam Long categoryId) {
        Task savedTask = taskServices.createTask(task, categoryId);
        ApiResponse<Task> response = new ApiResponse<>(true, "Task created successfully", savedTask);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<Task>>> getAllTasks() {
        List<Task> tasks = taskServices.getAllTasks();
        ApiResponse<List<Task>> response = new ApiResponse<>(true, "Tasks retrieved successfully", tasks);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PatchMapping("/{id}/toggle")
    public ResponseEntity<ApiResponse<Task>> toggleTaskStatus(@PathVariable Long id) {
        Task updatedTask = taskServices.toggleTaskStatus(id);
        ApiResponse<Task> response = new ApiResponse<>(true, "Task status toggled successfully", updatedTask);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}