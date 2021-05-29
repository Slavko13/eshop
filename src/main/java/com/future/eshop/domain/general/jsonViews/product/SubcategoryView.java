package com.future.eshop.domain.general.jsonViews.product;

public abstract class SubcategoryView {

    public interface SubcategoryMainView extends ProductView.ProductMainView {}

    public interface SubcategorySoloView  extends SubcategoryMainView {}



}
