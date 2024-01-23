package com.project.miniproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.miniproject.repository.UserRepository;

import lombok.RequiredArgsConstructor;
import com.project.miniproject.entity.User;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserService {

    @Autowired
    private final UserRepository userRepository;

    public List<User> getAllUsers(){

        List<User> users = userRepository.findAll();
        return users;

    }

    public User findUser(int id){

        Optional<User> user =  userRepository.findById(id);

        return user.get();

    }

    public void deleteUser(int id){
        userRepository.deleteById(id);
    }

    public User addUser(User user){

        User addedUser = userRepository.save(user);

        return addedUser;
    }






    
}
