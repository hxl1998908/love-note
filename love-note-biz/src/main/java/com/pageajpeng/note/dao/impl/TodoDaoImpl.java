package com.pageajpeng.note.dao.impl;

import com.pageajpeng.note.dao.TodoDao;
import com.pageajpeng.note.dto.TodoDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.*;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Set;

@Repository
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class TodoDaoImpl implements TodoDao {
    private static final String zSetKeyFormat = "todoSorted:%s";
    private static final String hashKeyFormat = "todo:%s";
    private static final String generateIdKey = "todoIdGenerate";

    private final RedisTemplate redisTemplate;

    private ZSetOperations<String, Long> zSetOperations;
    private HashOperations<String, Long, TodoDto> hashOperations;
    private ValueOperations<String, Long> valueOperations;

    @PostConstruct
    private void init() {
        zSetOperations = redisTemplate.opsForZSet();
        hashOperations = redisTemplate.opsForHash();
        valueOperations = redisTemplate.opsForValue();
    }

    @Override
    public List<TodoDto> getList(Long userId) {
        String todoSortedKey = todoSortedKey(userId);
        String todoObjectKey = todoObjectKey(userId);
        Set<Long> todoIds =  zSetOperations.range(todoSortedKey, 0, -1);
        List<TodoDto> todoDtos = hashOperations.multiGet(todoObjectKey, todoIds);
        return todoDtos;
    }

    @Override
    public void update(TodoDto todoDto) {
        String todoObjectKey = todoObjectKey(todoDto.getUserId());
        TodoDto storedDto = hashOperations.get(todoObjectKey, todoDto.getTodoId());
        if(storedDto == null){
            throw new RuntimeException("no todo to update, id:" + todoDto.getUserId());
        }
        hashOperations.put(todoObjectKey, todoDto.getTodoId(), todoDto);
    }

    @Override
    public void add(TodoDto todoDto) {
        String todoSortedKey = todoSortedKey(todoDto.getUserId());
        String todoObjectKey = todoObjectKey(todoDto.getUserId());
        Long todoId = valueOperations.increment(generateIdKey, 1);
        Long score = System.currentTimeMillis();
        todoDto.setTodoId(todoId);
        hashOperations.put(todoObjectKey, todoId, todoDto);
        zSetOperations.add(todoSortedKey, todoId, (double)score);
    }

    @Override
    public TodoDto get(Long userId, Long todoId) {
        String todoObjectKey  = todoObjectKey(userId);
        return hashOperations.get(todoObjectKey, todoId);
    }

    private String todoSortedKey(Long keyId) {
        return String.format(zSetKeyFormat, keyId);
    }

    private String todoObjectKey(Long keyId) {
        return String.format(hashKeyFormat, keyId);
    }
}
