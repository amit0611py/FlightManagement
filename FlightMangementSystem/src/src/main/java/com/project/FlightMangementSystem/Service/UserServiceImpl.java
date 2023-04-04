package com.project.FlightMangementSystem.Service;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.FlightMangementSystem.DAO.UserDao;
import com.project.FlightMangementSystem.DTO.User;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User addUser(User user) {
        validateUser(user);
        return userDao.addUser(user);
    }

    @Override
    public User viewUser(BigInteger userId) {
        return userDao.viewUser(userId);
    }

    @Override
    public List<User> viewUser() {
        return userDao.viewUser();
    }

    @Override
    public User updateUser(User user) {
        validateUser(user);
        return userDao.updateUser(user);
    }

    @Override
    public void deleteUser(BigInteger userId) {
        userDao.deleteUser(userId);
    }

    @Override
    public void validateUser(User user) {
        validatePhoneNumber(user.getUserPhone());
        validateEmail(user.getUserEmail());
        
        if (user.getUserName() == null || user.getUserName().isEmpty()) {
            throw new IllegalArgumentException("User name cannot be empty");
        }
        if (user.getUserPassword() == null || user.getUserPassword().isEmpty()) {
            throw new IllegalArgumentException("User password cannot be empty");
        }

        // Implement other validations
    }
    
    private void validatePhoneNumber(BigInteger phoneNumber) {
        String phoneNumberStr = String.valueOf(phoneNumber);
        if (phoneNumberStr.length() != 10 || phoneNumberStr.startsWith("0")) {
            throw new IllegalArgumentException("Invalid phone number");
        }
    }

    private void validateEmail(String email) {
        if (!email.matches("^[a-zA-Z0-9][a-zA-Z0-9._]*@[a-zA-Z0-9]+\\.[a-zA-Z]{2,}$")) {
            throw new IllegalArgumentException("Invalid email");
        }
    }
    

    // Implement other validation methods
}
