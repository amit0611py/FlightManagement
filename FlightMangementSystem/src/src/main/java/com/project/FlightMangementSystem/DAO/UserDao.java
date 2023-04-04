package com.project.FlightMangementSystem.DAO;

import java.math.BigInteger;
import java.util.List;

import com.project.FlightMangementSystem.DTO.User;

public interface UserDao {
    User addUser(User user);
    User viewUser(BigInteger userId);
    List<User> viewUser();
    User updateUser(User user);
    void deleteUser(BigInteger userId);
}