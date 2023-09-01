package com.syahid.test.blog.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class ArticlePaginationDto {

	@Schema(defaultValue = "")
	private String title;
	@Schema(defaultValue = "10")
	private Integer limit = 10;
	@Schema(defaultValue = "1")
	private Integer page = 1;
	@Schema(defaultValue = "createdAt")
	private String sortBy = "createdAt";
	@Schema(defaultValue = "desc")
	private String sortType = "desc";
}
