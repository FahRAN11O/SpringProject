package com.springprj.project.models;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserProfile implements Serializable {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	
	private String avatar;
	
	private String telephone;
	
	@OneToOne
	@JoinColumn(name = "user_id")
	private UserEntity user;
}
