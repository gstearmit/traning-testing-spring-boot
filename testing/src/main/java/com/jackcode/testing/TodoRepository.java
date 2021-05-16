package com.jackcode.testing;

import java.util.List;

public interface TodoRepository {
    List<Todo> findAll();
    Todo findById(int id);
}
