package com.cos.movie.domain;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class SaveReqDto {
	@NotBlank
	private String title;
	@NotBlank
	private String rating;
}
