package com.example.listingapp.service;

import com.example.listingapp.entity.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    User getUserById(int id);

    User addUser(User user);

    void deleteUserByID(int id);



}
