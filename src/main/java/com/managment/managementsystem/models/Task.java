package com.managment.managementsystem.models;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "task_seq")
    @SequenceGenerator(name = "task_seq", sequenceName = "task_sequence", allocationSize = 1)
    private Long id;
    @Column(nullable = false)
    private String title;
    private String description;
    private LocalDate dueDate;
    private boolean completed = false;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    public Task() { }

    public Task(String title, String description, LocalDate dueDate, boolean completed, Category category) {
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.completed = completed;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
