package com.yellowmovement.site;

import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class User {
	
	@NotNull
	private final String name;
	
	@NotNull
	private final String email;
	
	@NotNull
	private final String password;
	
	@NotNull
	private final String sex = "Female";
}
