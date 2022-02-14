package com.waires.Waires.domain.dto;

public class AuthenticationOutputDTO {
    private String jwt;

    public AuthenticationOutputDTO(String jwt) {
        this.jwt = jwt;
    }

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }
}
