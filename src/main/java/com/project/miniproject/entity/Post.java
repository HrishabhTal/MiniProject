package com.project.miniproject.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post {

    @Id
	@GeneratedValue
	private Integer id;
	
	
	private String description;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
	private User user;

    
}
