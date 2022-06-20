package com.gad.sales_v2.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User saveOrUpdate(User user){
        return userRepository.save(user);
    }

    public UserDTO authenticate(User user){
        return getUserDTO(userRepository.getByUsernameAndPassword(user.getUsername(), user.getPassword()));
    }

    public User getById(Long id){
        return userRepository.getById(id);
    }

    private UserDTO getUserDTO(String result){
        if(result != null){
            String[] tokens = result.split(",");
            return new UserDTO(Long.parseLong(tokens[0]), tokens[1]);
        }
        return new UserDTO();
    }
}
