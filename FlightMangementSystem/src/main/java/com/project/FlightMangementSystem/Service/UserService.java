package com.project.FlightMangementSystem.Service;

import java.math.BigInteger;
import java.util.List;

import com.project.FlightMangementSystem.DTO.User;

public interface UserService {
    User addUser(User user);
    User viewUser(BigInteger userId);
    List<User> viewUser();
    User updateUser(User user);
    void deleteUser(BigInteger userId);
    void validateUser(User user);
}
