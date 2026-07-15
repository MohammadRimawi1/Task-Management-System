package com.managment.managementsystem.services;

import com.managment.managementsystem.models.Category;
import com.managment.managementsystem.models.Task;
import com.managment.managementsystem.repositories.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServices {
    private final TaskRepository taskRepository;
    private final CategoryServices categoryServices;

    public TaskServices(TaskRepository taskRepository, CategoryServices categoryServices) {
        this.taskRepository = taskRepository;
        this.categoryServices = categoryServices;
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public List<Task> getTasksByStatus(boolean completed) {
        return taskRepository.findByCompleted(completed);
    }

    public Task createTask(Task task, String categoryId) {
        Category category = categoryServices.getCategoryById(categoryId);
        task.setCategory(category);
        return taskRepository.save(task);
    }

    public Task toggleTaskStatus(String id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task Doesn't exist " + id));

        task.setCompleted(!task.isCompleted());

        return taskRepository.save(task);
    }
}
