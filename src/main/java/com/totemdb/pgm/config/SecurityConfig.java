package com.totemdb.pgm.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.cors() // 启用 CORS
                .and()
                .csrf().disable() // 禁用 CSRF（跨域 POST 请求时必须禁用）
                .authorizeHttpRequests()
                .requestMatchers("/**").permitAll() // 放行 `/user` 路径
                .anyRequest().authenticated(); // 其他路径需要认证
        return http.build();
    }
}
