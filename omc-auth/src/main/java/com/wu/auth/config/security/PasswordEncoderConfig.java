package com.wu.auth.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author Haixin Wu
 * @date 2021/12/18 18:43
 * @since 1.0
 */
@Configuration
public class PasswordEncoderConfig {
    @Bean(name = "pw")
    public PasswordEncoder pw() {
        return new BCryptPasswordEncoder();
    }
}

