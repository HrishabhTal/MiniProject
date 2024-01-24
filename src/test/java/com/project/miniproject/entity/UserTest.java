package com.project.miniproject.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;
import java.util.Optional;
import static org.assertj.core.api.Assertions.assertThat;

import com.project.miniproject.repository.UserRepository;

@SpringBootTest
@DataJpaTest
public class UserTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testCreateUser() {
        
        String name = "Rick";
        User user = new User(null, name, null);
        
        userRepository.save(user);
        
        assertEquals(user.getName(),name);
    }

    @Test
    public void testListUsers() {
        
        List<User> users = (List<User>) userRepository.findAll();
        
        assertThat(users.size()).isGreaterThan(0);
    }

    @Test
    public void testDeleteUser() {
        
        String name ="Rick";
        User user = userRepository.save(new User(null,name,null));
        Integer userId = user.getId();
        
        userRepository.delete(user);
        Optional<User> deletedUser = userRepository.findById(userId);
        
        assertEquals(deletedUser,null);
    }

    
}
