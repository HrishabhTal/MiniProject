package com.project.miniproject.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.project.miniproject.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{
    
}
