package com.project.FlightMangementSystem.DAO;

import java.util.List;
import java.math.BigInteger;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.project.FlightMangementSystem.DTO.User;

@Repository
public class UserDaoImpl implements UserDao {

    private static final List<User> userList = new ArrayList<>();
    
    public UserDaoImpl() {
        // Adding a default user to the userList
        userList.add(new User("admin", BigInteger.valueOf(1), "admin", "admin", BigInteger.valueOf(1234567890), "admin@example.com"));
    }
    

    @Override
    public User addUser(User user) {
        userList.add(user);
        return user;
    }

    @Override
    public User viewUser(BigInteger userId) {
        return userList.stream()
                .filter(user -> user.getUserId().equals(userId))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<User> viewUser() {
        return userList;
    }

    @Override
    public User updateUser(User user) {
        User existingUser = viewUser(user.getUserId());
        if (existingUser != null) {
            existingUser.setUserType(user.getUserType());
            existingUser.setUserName(user.getUserName());
            existingUser.setUserPassword(user.getUserPassword());
            existingUser.setUserPhone(user.getUserPhone());
            existingUser.setUserEmail(user.getUserEmail());
        }
        return existingUser;
    }

    @Override
    public void deleteUser(BigInteger userId) {
        userList.removeIf(user -> user.getUserId().equals(userId));
    }
}
