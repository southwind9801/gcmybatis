package com.southwind.repository;

import com.southwind.entity.User;

import java.util.List;

public interface UserRepository {
    public User get(User user);
    public int update(User user);
    public List<User> getByIds(User user);
}
