package com.wu.auth.config.security;

import com.wu.common.domain.enums.RoleEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * @author Haixin Wu
 * @date 2021/12/17 21:42
 * @since 1.0
 */
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean(name = "pw")
    public PasswordEncoder pw() {
        return new BCryptPasswordEncoder();
    }

    private final JWTAuthenticationFilter jwtAuthenticationFilter;
    private final RestAccessDeniedHandler restAccessDeniedHandler;
    private final RestAuthenticationSuccessHandler restAuthenticationSuccessHandler;
    private final RestAuthenticationFailureHandler restAuthenticationFailureHandler;
    private final RestLoginAuthenticationEntryPoint restLoginAuthenticationEntryPoint;

    @Autowired
    public SecurityConfig(JWTAuthenticationFilter jwtAuthenticationFilter, RestAccessDeniedHandler restAccessDeniedHandler, RestAuthenticationSuccessHandler restAuthenticationSuccessHandler, RestAuthenticationFailureHandler restAuthenticationFailureHandler, RestLoginAuthenticationEntryPoint restLoginAuthenticationEntryPoint) {
        this.jwtAuthenticationFilter = jwtAuthenticationFilter;
        this.restAccessDeniedHandler = restAccessDeniedHandler;
        this.restAuthenticationSuccessHandler = restAuthenticationSuccessHandler;
        this.restAuthenticationFailureHandler = restAuthenticationFailureHandler;
        this.restLoginAuthenticationEntryPoint = restLoginAuthenticationEntryPoint;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 关闭csrf
        http.cors().and().csrf().disable()
                .logout()
                .logoutUrl("/moc/api/user/logout")
                .and()
                // 未登录访问处理
                .httpBasic().authenticationEntryPoint(restLoginAuthenticationEntryPoint)
                .and()
                .formLogin()
                // 用户登录调用的接口
                .loginProcessingUrl("/omc/api/user/login")
                // 登录成功处理
                .successHandler(restAuthenticationSuccessHandler)
                // 登录失败处理
                .failureHandler(restAuthenticationFailureHandler)
                .permitAll()
                .and()
                .exceptionHandling()
                // 无权限访问接口处理
                .accessDeniedHandler(restAccessDeniedHandler)
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                // 权限设置
                // 只有学生身份可以访问学生接口
                .antMatchers("/omc/api/user/**").hasRole(RoleEnum.USER.getName())
                // 只有管理员身份可以访问管理员接口
                .antMatchers("/omc/api/admin/**").hasRole(RoleEnum.ADMIN.getName())
                // 所有人都可以访问
                .antMatchers("/omc/api/user/login").permitAll()
                .antMatchers("/omc/api/user/register").permitAll()
                .anyRequest().authenticated()
                .and()
                // 自定义jwt验证过滤器
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .headers().cacheControl();
    }
}

