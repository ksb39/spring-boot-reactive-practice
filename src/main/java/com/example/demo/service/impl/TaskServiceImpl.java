package com.example.demo.service.impl;

import com.example.demo.domain.Task;
import com.example.demo.repository.TaskRepository;
import com.example.demo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public Task create(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public Iterable<Task> read() {
        return taskRepository.findAll();
    }

    @Override
    public void reset() {
        taskRepository.deleteAll();
    }

}
