package com.example.ws04.dto;

import lombok.Getter;

public class UserDto {
    @Getter
    private int userSeq;
    @Getter
    private String name;
    @Getter
    private String password;
    @Getter
    private String email;
    @Getter
    private String phone;
    private boolean isSleep;

    public UserDto() {

    }

    public UserDto(int userSeq, String name, String password, String email, String phone, boolean isSleep) {
        this.userSeq = userSeq;
        this.name = name;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.isSleep = isSleep;
    }

    public void setUserSeq(int userSeq) {
        this.userSeq = userSeq;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isSleep() {
        return isSleep;
    }

    public void setSleep(boolean sleep) {
        isSleep = sleep;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "userSeq=" + userSeq +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", isSleep=" + isSleep +
                '}';
    }
}
