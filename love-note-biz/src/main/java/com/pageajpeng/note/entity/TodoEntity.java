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
public class TodoEntity {
    private Long todoId;
    private Long userId;
    private String name;
    private String description;

    public static TodoEntity of(TodoDto todoDto) {
        return TodoEntity.builder().todoId(todoDto.getTodoId())
                .description(todoDto.getDescription()).name(todoDto.getName())
                .userId(todoDto.getUserId()).build();
    }
}
