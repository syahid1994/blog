package com.syahid.test.blog.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.syahid.test.blog.models.Article;

@EnableJpaRepositories
public interface ArticleRepository extends JpaRepository<Article, Long> {
	
	@Query("select a from Article a where lower(a.title) = lower(?1) ")
	List<Article> findByTitle(String title);
	
	@Query("select a from Article a where lower(a.title) = lower(?1) and a.id != ?2 ")
	List<Article> findByTitleAndNotEqualsId(String title, Long id);

	Page<Article> findAll(Specification<Article> specification, Pageable pageable);
}
