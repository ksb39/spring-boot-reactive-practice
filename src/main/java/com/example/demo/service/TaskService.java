package com.example.demo.service;

import com.example.demo.domain.Task;

public interface TaskService {

    Task create(Task task);

    Iterable<Task> read();

    void reset();
}
