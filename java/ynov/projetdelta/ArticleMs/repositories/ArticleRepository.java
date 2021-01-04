package ynov.projetdelta.ArticleMs.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ynov.projetdelta.ArticleMs.model.Article;

@Repository
public interface ArticleRepository extends CrudRepository<Article, Integer> {

}
