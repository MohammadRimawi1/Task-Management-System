package com.managment.managementsystem.services;

import com.managment.managementsystem.models.Task;
import com.managment.managementsystem.repositories.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServices {
    private final TaskRepository taskRepository;

    public TaskServices(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public List<Task> getTasksByStatus(boolean completed) {
        return taskRepository.findByCompleted(completed);
    }

    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    public Task toggleTaskStatus(Long id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task Doesn't exist " + id));

        task.setCompleted(!task.isCompleted());

        return taskRepository.save(task);
    }
}
