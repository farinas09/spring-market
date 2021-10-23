package com.farinas.market.domain.dto;

import com.farinas.market.security.enums.RoleName;

public class Role {
    private int id;
    private RoleName roleName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public RoleName getRoleName() {
        return roleName;
    }

    public void setRoleName(RoleName roleName) {
        this.roleName = roleName;
    }
}
