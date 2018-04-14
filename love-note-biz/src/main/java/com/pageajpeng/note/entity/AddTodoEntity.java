package com.pageajpeng.note.entity;

import com.pageajpeng.note.dto.TodoDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddTodoEntity {
    private Long todoId;
    private Long userId;
    private String name;
    private String description;

    public static TodoDto as(AddTodoEntity addTodoEntity) {
        return new TodoDto(addTodoEntity.getTodoId(), addTodoEntity.getUserId(),
                addTodoEntity.getName(), addTodoEntity.getDescription());
    }
}
