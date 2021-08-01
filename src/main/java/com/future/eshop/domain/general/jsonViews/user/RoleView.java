package com.future.eshop.domain.general.jsonViews.user;

public abstract class RoleView {

    public interface RoleMainView {}
    public interface RoleSoloView extends UserView.UserMainView, AuthorityView.AuthorityMainView {}


}
