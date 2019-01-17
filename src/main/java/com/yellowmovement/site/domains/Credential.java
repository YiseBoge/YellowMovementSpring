package com.yellowmovement.site.domains;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class Credential {
	
	@NotBlank(message="Email cannot be Empty")
	private String loginEmail;
	
	@NotBlank(message="Password cannot be Empty")
	private String loginPassword;
}
