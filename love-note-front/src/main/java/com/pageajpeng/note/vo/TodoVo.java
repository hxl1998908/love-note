package com.pageajpeng.note.vo;

import com.pageajpeng.note.entity.TodoEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TodoVo {
    private Long todoId;
    private Long userId;
    private String name;
    private String description;

    public static TodoVo of(TodoEntity todoEntity) {
        return TodoVo.builder().todoId(todoEntity.getTodoId())
                .userId(todoEntity.getUserId()).name(todoEntity.getName())
                .description(todoEntity.getDescription()).build();
    }
}
