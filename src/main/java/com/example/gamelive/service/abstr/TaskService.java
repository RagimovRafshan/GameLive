package com.example.gamelive.service.abstr;

import com.example.gamelive.model.entity.Task;

public interface TaskService {
    Task save(Task task);
    Task update(Task task);
    void deleteById(Long taskId);
}
