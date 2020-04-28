package com.mic.pro.service.admin.model;

import lombok.Data;

@Data
public class LoginByPasswordOVO {
    private String userId;
    private String userName;
    private String telephone;
    private String password;
}
