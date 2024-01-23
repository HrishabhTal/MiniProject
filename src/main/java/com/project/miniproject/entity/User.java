package com.project.miniproject.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
	@GeneratedValue
	private Integer id;

    @Column(unique=true)
    private String name;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<Post> posts;
}
