package com.yellowmovement.site;

import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Credential {
	
	@NotNull
	private final String loginEmail;
	
	@NotNull
	private final String loginPassword;
}
