package com.future.eshop.domain.general.jsonViews.user;

public abstract class UserView {

    public interface UserMainView {}
    public interface UserSoloView extends UserMainView, RoleView.RoleMainView {}
    public interface UserFullView extends UserMainView, RoleView.RoleMainView {}

}
