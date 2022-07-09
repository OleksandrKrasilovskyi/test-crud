package com.example.tournament_spring_hibernate.entity;

public enum Permission {
    USERS_READ("read"),
    USERS_WRITE("write");

    private final String permission;

    Permission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
