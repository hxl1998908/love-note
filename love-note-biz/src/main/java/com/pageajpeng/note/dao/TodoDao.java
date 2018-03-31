package com.pageajpeng.note.dao;

import com.pageajpeng.note.dto.TodoDto;

import java.util.List;

public interface TodoDao {
    List<TodoDto> getList(Long userId);
    void update(TodoDto todoDto);
    void add(TodoDto todoDto);
    TodoDto get(Long userId, Long todoId);
}
