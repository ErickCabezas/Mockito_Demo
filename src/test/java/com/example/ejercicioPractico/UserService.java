package com.example.ejercicioPractico;

public class UserService {
    private UserRepository userRepository;

    // Constructor que inyecta el UserRepository
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    // Método que usa el UserRepository para obtener un usuario por ID
    public User getUserById(String id) {
        return userRepository.findUserById(id);
    }
}
