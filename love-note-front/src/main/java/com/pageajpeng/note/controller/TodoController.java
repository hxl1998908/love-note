package com.pageajpeng.note.controller;

import com.pageajpeng.note.entity.AddTodoEntity;
import com.pageajpeng.note.service.TodoService;
import com.pageajpeng.note.vo.TodoVo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("ng/todo")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class TodoController {

    private static final Long USER_ID = 1L;

    private final TodoService todoService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<TodoVo> get() {
        return todoService.getList(USER_ID).stream().map(TodoVo::of).collect(Collectors.toList());
    }

    @RequestMapping(value = "", method = RequestMethod.PUT)
    public void save(@RequestBody AddTodoEntity addTodoEntity) {
        addTodoEntity.setUserId(USER_ID);
        todoService.store(addTodoEntity);
    }

    @RequestMapping(value = "/{todoId}", method = RequestMethod.GET)
    public TodoVo get(
            @PathVariable(value = "todoId") Long todoId
    ) {
        return TodoVo.of(todoService.get(USER_ID, todoId));
    }

    @RequestMapping(value = "", method = RequestMethod.PUT)
    public void update(@RequestBody AddTodoEntity addTodoEntity) {
        
    }
}
