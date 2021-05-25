package com.future.eshop.repository.news;

import com.future.eshop.domain.newsPortal.NewsPortal;
import com.future.eshop.domain.product.Product;
import org.springframework.data.repository.CrudRepository;

public interface NewsPortalRepo extends CrudRepository<NewsPortal, Integer> {
}
