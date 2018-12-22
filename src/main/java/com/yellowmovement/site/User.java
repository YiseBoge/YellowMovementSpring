package com.yellowmovement.site;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.text.SimpleDateFormat;
import java.util.Date;

@Data
@Entity
@Table(name="users")
public class User {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long userId;

	@NotBlank(message = "You must have a Name.")
	private String name;

	@Column(unique = true)
	@NotBlank(message = "Email is Required.")
	private String email;
	
	@NotBlank(message = "Password is Required.")
	private String password;

	@NotBlank
	private String sex;

	@Column(columnDefinition = "varchar(10) default 'USER'")
	@Enumerated(EnumType.STRING)
	private Role role;

	public enum Role {
		ADMIN, BLOGGER, USER
	}

	private Date joiningDate;

	private String dateString;

	@PrePersist
	void joiningDate() {
		SimpleDateFormat format = new SimpleDateFormat("h:mm a - EEE, MMM d");

		this.joiningDate = new Date();
		this.dateString = format.format(this.joiningDate);
	}
}



