package com.syahid.test.blog.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.Transactional;

import com.syahid.test.blog.models.Article;

@EnableJpaRepositories
public interface ArticleRepository extends JpaRepository<Article, Long> {
	
	@Query("select a from Article a where lower(a.title) = lower(:title) ")
	List<Article> findByTitle(String title);
	
	@Query("select a from Article a where lower(a.title) = lower(:title) and a.id != :id ")
	List<Article> findByTitleAndNotEqualsId(String title, Long id);

	Page<Article> findAll(Specification<Article> specification, Pageable pageable);
	
	@Transactional
	@Modifying
	@Query("update Article set body = :body where title = :title")
	void updateBodyByTitle(String body, String title);
	
	@Transactional
	@Modifying
	@Query("update Article set body = :title where title = :title")
	void updateBodyByTitle(String title);
}
