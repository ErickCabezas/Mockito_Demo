package com.example.ejercicioPractico;

public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public User getUserById(String id) {
        return userRepository.findUserById(id);
    }
}
