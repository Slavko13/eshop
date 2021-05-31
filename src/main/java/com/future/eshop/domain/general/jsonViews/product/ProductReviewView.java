package com.future.eshop.domain.general.jsonViews.product;

import com.future.eshop.domain.general.jsonViews.user.UserView;

public abstract class ProductReviewView {

    public interface ProductReviewMainView {}

    public interface ProductReviewUserView extends UserView.UserMainView, ProductView.ProductMainView {}

    public interface ProductReviewSoloView extends ProductReviewMainView {}

    public interface ProductReviewFullView extends ProductReviewSoloView {}


}
