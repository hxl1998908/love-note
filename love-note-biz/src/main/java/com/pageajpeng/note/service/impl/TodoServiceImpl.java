package com.pageajpeng.note.service.impl;

import com.pageajpeng.note.dao.TodoDao;
import com.pageajpeng.note.dto.TodoDto;
import com.pageajpeng.note.entity.AddTodoEntity;
import com.pageajpeng.note.entity.TodoEntity;
import com.pageajpeng.note.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class TodoServiceImpl implements TodoService {
    private final TodoDao todoDao;

    @Override
    public List<TodoEntity> getList(Long userId) {
        return todoDao.getList(userId).stream().
                map(TodoEntity::of).collect(Collectors.toList());
    }

    @Override
    public void store(AddTodoEntity addTodoEntity) {
        TodoDto todoDto = AddTodoEntity.as(addTodoEntity);
        todoDao.add(todoDto);
    }

    @Override
    public TodoEntity get(Long userId, Long todoId) {
        return TodoEntity.of(todoDao.get(userId, todoId));
    }


}
