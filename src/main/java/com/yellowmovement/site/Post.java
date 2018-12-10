package com.yellowmovement.site;

import java.util.Date;

import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Post {
	
	@NotNull
	private final String id;
	
	@NotNull
	private final String title;
	
	@NotNull
	private final String content;
	
	@NotNull
	private final String category;
	
	@NotNull
	private final String postedDate;
	
	private final String image = null;
}
