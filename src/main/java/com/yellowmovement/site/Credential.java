package com.yellowmovement.site;

import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
public class Credential {
	
	@NotNull(message="Email cannot be Empty")
	private String loginEmail;
	
	@NotNull(message="Password cannot be Empty")
	private String loginPassword;
}
