package com.future.eshop.dto.user;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class UsernameSuggest {

    public UsernameSuggest(Boolean usernameExist) {
        this.usernameExist = usernameExist;
    }

    private List<String> freeUsernames;
    private Boolean usernameExist;

}
