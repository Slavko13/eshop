package com.future.eshop.domain.general.jsonViews.product;

public abstract class ProductView {

    public interface ProductMainView extends BrandView.BrandMainView {}

    public interface ProductSoloView extends ProductMainView, ProductReviewView.ProductReviewMainView {}

    public interface ProductFullView extends ProductSoloView,  BrandView.BrandSoloView, SubcategoryView.SubcategoryMainView {}


}
