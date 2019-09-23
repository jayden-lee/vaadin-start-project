package com.jayden.admin.model;

import lombok.Getter;

public class AccountDto {

    @Getter
    public static class CreateRequest {

        private String username;
        private String password;
        private String role;

        public static CreateRequest of(String username, String password, String role) {
            CreateRequest request = new CreateRequest();
            request.username = username;
            request.password = password;
            request.role = role;
            return request;
        }
    }
}
