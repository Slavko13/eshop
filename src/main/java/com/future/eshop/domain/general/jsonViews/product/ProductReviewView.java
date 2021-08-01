package com.future.eshop.domain.general.jsonViews.product;

public abstract class ProductReviewView {

    public interface ProductReviewMainView {}

    public interface ProductReviewSoloView extends ProductReviewMainView {}

    public interface ProductReviewFullView extends ProductReviewMainView {}


}
