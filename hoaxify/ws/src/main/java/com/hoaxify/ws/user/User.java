package com.hoaxify.ws.user;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Table(name = "UserEntity")
@Data
@Entity
public class User {
	@Id
	@GeneratedValue
	private long id;
	
	@NotNull(message ="{hoaxify.constraints.username.NotNull.message}")
	@UniqueUsername
	@Size(min = 4 ,max=255)
	private String username;
	
	@NotNull
	@Size(min = 4 ,max=255)
	private String displayname;
	
	
	@NotNull
	@Size(min = 8,max=255)
	@Pattern(regexp="^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).*$",message = "{hoaxify.constraints.password.Pattern.message}")
	private String password;
	


}
