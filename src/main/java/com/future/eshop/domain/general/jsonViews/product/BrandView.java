package com.future.eshop.domain.general.jsonViews.product;

public abstract class BrandView {

    public interface BrandMainView {}

    public interface BrandSoloView extends BrandMainView, ProductReviewView.ProductReviewMainView {}

    public interface BrandFullView extends BrandSoloView {}

}
