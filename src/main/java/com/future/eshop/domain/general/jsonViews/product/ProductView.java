package com.future.eshop.domain.general.jsonViews.product;

public abstract class ProductView {

    public interface ProductMainView  {}

    public interface ProductSoloView extends BrandView.BrandMainView, ProductMainView, ProductReviewView.ProductReviewMainView, SubcategoryView.SubcategoryMainView {}

    public interface ProductFullView extends ProductMainView,  BrandView.BrandSoloView, SubcategoryView.SubcategoryMainView {}


}
