package com.syahid.test.blog;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.syahid.test.blog.models.Article;
import com.syahid.test.blog.repositories.ArticleRepository;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ArticleTest {

	@Autowired
    private ArticleRepository articleRepository;
	
	@Test
	@Order(1)
	@Rollback(false)
	public void create() {
		long count = articleRepository.count();
		Article article = new Article();
		article.setTitle("Lorem ipsum dolor sit amet");
		article.setBody("Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua");
		article.setAuthor("Anon");
		articleRepository.save(article);

		long recount = articleRepository.count();
		Assertions.assertEquals(recount, (count + 1l));
	}
	
	@Test
	@Order(2)
	public void getAll() {
		List<Article> articles = articleRepository.findAll();
		Assertions.assertTrue(articles.size() > 0l);
	}
	
	@Test
	@Order(3)
	public void getDetail() {
		Long id = 1l;
		Article article = articleRepository.findById(id).orElse(null);
		Assertions.assertEquals(id, article.getId());
	}
	
	@Test
	@Order(4)
	public void update() {
		Long id = 1l;
		Article article = articleRepository.findById(id).orElse(null);
		String titleEdit = "title edit";
		article.setTitle(titleEdit);
		Article articleEdit = articleRepository.save(article);
		
		Assertions.assertEquals(titleEdit, articleEdit.getTitle());
	}
	
	@Test
	@Order(5)
	public void delete() {
		long count = articleRepository.count();
		Long id = 1l;
		Article article = articleRepository.findById(id).orElse(null);
		articleRepository.delete(article);

		long recount = articleRepository.count();
		Assertions.assertEquals(recount, (count - 1l));
	}
}
