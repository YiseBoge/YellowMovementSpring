package com.yellowmovement.site;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Date;

@Data
@Entity
@Table(name="users")
public class User {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long userId;

	@NotNull
	private String name;
	
	@NotNull
	private String email;
	
	@NotNull
	private String password;

	@NotNull
	private String sex;

	@Enumerated(EnumType.STRING)
	private Role role;

	public enum Role {
		ADMIN, BLOGGER, USER
	}

	private Date joiningDate;

	@PrePersist
	void placedAt() {
		this.joiningDate = new Date();
	}
}



