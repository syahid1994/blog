package com.syahid.test.blog.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class ArticleDto {

	private String title;
	private String body;
	private String author;
}
