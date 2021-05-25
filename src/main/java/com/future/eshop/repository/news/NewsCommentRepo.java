package com.future.eshop.repository.news;

import com.future.eshop.domain.newsPortal.NewsComment;
import org.springframework.data.repository.CrudRepository;

public interface NewsCommentRepo extends CrudRepository<NewsComment, Integer> {
}
