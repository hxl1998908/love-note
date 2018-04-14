package com.pageajpeng.note.service;

import com.pageajpeng.note.entity.AddTodoEntity;
import com.pageajpeng.note.entity.TodoEntity;

import java.util.List;

public interface TodoService {
    List<TodoEntity> getList(Long userId);

    TodoEntity store(AddTodoEntity addTodoEntity);

    TodoEntity get(Long userId, Long todoId);

    void update(AddTodoEntity addTodoEntity);
}
