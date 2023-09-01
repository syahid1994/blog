package com.syahid.test.blog.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.syahid.test.blog.dto.ArticleDto;
import com.syahid.test.blog.dto.ArticlePaginationDto;
import com.syahid.test.blog.dto.ResponseDto;
import com.syahid.test.blog.dto.ResponsePaginationDto;
import com.syahid.test.blog.exceptions.AnException;
import com.syahid.test.blog.models.Article;
import com.syahid.test.blog.services.ArticleService;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;

@RestController
@RequestMapping("/article")
public class ArticleController {
	
	@Autowired
	ArticleService articleService;

	@PostMapping
	public ResponseDto<Object> create(@RequestBody ArticleDto param) throws AnException {
		articleService.create(param);
		return ResponseDto.success();
	}
	
	//get mapping unsupported dto
	@GetMapping
	public ResponsePaginationDto<List<Article>> getList(@RequestParam(required = false, defaultValue = "")String title, 
			@RequestParam(required = false, defaultValue = "createdAt")String sortBy, 
			@RequestParam(required = false, defaultValue = "desc")String sortType,
			@RequestParam(required = false, defaultValue = "1")Integer page,
			@RequestParam(required = false, defaultValue = "10")Integer limit) {
		Page<Article> data = articleService.getList(title, sortBy, sortType, page, limit);
		return new ResponsePaginationDto(data);
	}
	
	@GetMapping("/{id}")
	public ResponseDto<Article> getById(@PathVariable("id") int id) {
		long idl = id;
		return ResponseDto.success(articleService.getById(idl));
	}
	
	@PutMapping("/{id}")
	public ResponseDto<Object> update(@PathVariable("id") int id, @RequestBody ArticleDto param) throws AnException {
		long idl = id;
		articleService.update(idl, param);
		return ResponseDto.success();
	}
	
	@DeleteMapping("/{id}")
	public ResponseDto<Object> delete(@PathVariable("id") int id) throws AnException {
		long idl = id;
		articleService.delete(idl);
		return ResponseDto.success();
	}
}
