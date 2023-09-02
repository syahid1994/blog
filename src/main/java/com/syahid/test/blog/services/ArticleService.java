package com.syahid.test.blog.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.syahid.test.blog.dto.ArticleDto;
import com.syahid.test.blog.exceptions.AnException;
import com.syahid.test.blog.models.Article;
import com.syahid.test.blog.repositories.ArticleRepository;

import jakarta.persistence.EntityManager;

@Service
public class ArticleService {

	@Autowired
	ArticleRepository articleRepository;
	
	@Autowired
	EntityManager entityManager;
	
	@Autowired
	ObjectMapper objectMapper;
	
	public void create(ArticleDto param) throws AnException {
		if (articleRepository.findByTitle(param.getTitle()).size() > 0) {
			throw new AnException(Constant.TITLE_EXIST);
		}
		
		Article article = new Article();
		article.setTitle(param.getTitle());
		article.setBody(param.getBody());
		article.setAuthor(param.getAuthor());
		articleRepository.save(article);
	}
	
	public Page<Article> getList(String title, String sortBy, String sortType, Integer page, Integer limit) {
		if (sortBy.equals("")) {
			sortBy = Constant.DEFAULT_SORT_BY;
		}
		if (sortType.equals("")) {
			sortType = Constant.DEFAULT_SORT_TYPE;
		}
		Sort sort = Sort.by(Direction.fromString(sortType), sortBy);
		Pageable pageable = PageRequest.of((page - 1), limit, sort);
		Specification<Article> specification = buildSpecification(title);
		if (specification == null) {
			return articleRepository.findAll(pageable);
		} else {
			return articleRepository.findAll(specification, pageable);
		}
	}
	
	public Specification<Article> buildSpecification(String title) {
		return (root, query, builder) -> {
			if (!title.equals("")) {
				return builder.like(
						builder.lower(root.get("title")), 
						title.toLowerCase()
						);
			}
			return null;
		};
	}
	
	public Article getById(Long id) {
		return articleRepository.findById(id).orElse(null);
	}
	
	public void update(Long id, ArticleDto param) throws AnException {
		Article article = articleRepository.findById(id).orElse(null);
		if (article == null) {
			throw new AnException(Constant.DATA_NOT_FOUND);
		}
		if (articleRepository.findByTitleAndNotEqualsId(param.getTitle(), id).size() > 0) {
			throw new AnException(Constant.TITLE_EXIST);
		}
		article.setTitle(param.getTitle());
		article.setBody(param.getBody());
		article.setAuthor(param.getAuthor());
		articleRepository.save(article);
	}
	
	public void delete(Long id) throws AnException {
		Article article = articleRepository.findById(id).orElse(null);
		if (article == null) {
			throw new AnException(Constant.DATA_NOT_FOUND);
		}
		articleRepository.delete(article);
	}
	
	private static class Constant {
		
		private static String TITLE_EXIST = "Title exist";
		private static String DATA_NOT_FOUND = "Data not found";
		
		private static String DEFAULT_SORT_BY = "createdAt";
		private static String DEFAULT_SORT_TYPE = "asc";
	}
}
