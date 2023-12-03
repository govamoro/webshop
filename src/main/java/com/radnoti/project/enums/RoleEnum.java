package com.radnoti.project.enums;

public enum RoleEnum {
    ADMIN(1, "admin"),
    USER(2, "user");

    private final Integer id;
    private final String type;

    RoleEnum(Integer id, String type) {
        this.id = id;
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public String getType() {
        return type;
    }
}
