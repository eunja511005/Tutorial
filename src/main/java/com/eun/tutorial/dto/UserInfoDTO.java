package com.eun.tutorial.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserInfoDTO implements Serializable {

    private static final long serialVersionUID = 658724990821020276L;

    private Long id;
    private String username;
    private String password;
    private String email;
    private String role;
    private String picture;
    private boolean isEnable;
    private String createId;
    private String createTime;
    private String updateId;
    private String updateTime;

    public UserInfoDTO update(String name, String picture){
        this.username = name;
        this.picture = picture;
        return this;
    }

}

