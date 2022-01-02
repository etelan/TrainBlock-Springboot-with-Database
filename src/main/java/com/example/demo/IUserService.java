package com.example.demo;

import java.util.List;

public interface IUserService {

    List<User> findAll();

    Long count();
}
