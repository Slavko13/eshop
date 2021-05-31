package com.future.eshop.domain.general.jsonViews.user;

public abstract class UserView {


    public interface UserMainView {}

    public interface UserSoloView extends UserMainView {}

    public interface UserFullView extends UserSoloView, RoleView.RoleFullView {}



}
