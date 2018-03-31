package com.pageajpeng.note.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TodoDto implements Serializable{
    private Long todoId;
    private Long userId;
    private String name;
    private String description;
}
