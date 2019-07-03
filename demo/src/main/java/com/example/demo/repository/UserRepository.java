package com.example.demo.repository;

import org.springframework.stereotype.Repository;
import com.example.demo.domain.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class UserRepository {

    private final ConcurrentMap<Integer,User> repository = new ConcurrentHashMap<>();
    private final static AtomicInteger idGenerator = new AtomicInteger();

    public boolean save(User user){
        Integer id = idGenerator.incrementAndGet();
        user.setId(id);
        return repository.put(id,user) == null;
    }
}
