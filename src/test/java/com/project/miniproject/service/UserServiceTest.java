package com.project.miniproject.service;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Optional;
import com.project.miniproject.entity.User;
import com.project.miniproject.repository.UserRepository;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    
    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;
    
    @Test
    public void givenUserExistsWhileSearchingThenUserIsFound() {
    
    String name = "Rick";
    User user = new User(1,name, null);
    when(userRepository.findById(user.getId())).thenReturn(Optional.of(user));

    
    User gotUser = userService.findUser(user.getId());

    
    assertThat(gotUser).isNotNull();
    assertThat(gotUser.getName()).isEqualTo(name);
    verify(userRepository).findById(user.getId());
}
    
}
