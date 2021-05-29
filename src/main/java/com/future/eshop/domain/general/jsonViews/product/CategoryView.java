package com.future.eshop.domain.general.jsonViews.product;

public abstract class CategoryView {

    public interface CategoryMainView extends SubcategoryView.SubcategoryMainView {}

    public interface CategorySoloView  extends CategoryMainView {}


}
