package com.project.miniproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.miniproject.entity.Post;

public interface PostRepository extends JpaRepository<Post, Integer> {
    
}
