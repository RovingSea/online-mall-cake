package com.wu.auth.config.security;

import com.wu.common.domain.User;
import com.wu.common.domain.enums.RoleEnum;
import com.wu.common.service.user.UserService;
import com.wu.common.utility.util.TokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 校验JWT
 * @author Haixin Wu
 * @date 2021/12/17
 * @time 22:12
 * @since 1.0
 */
@Component
@Slf4j
public class JWTAuthenticationFilter extends OncePerRequestFilter {

    @DubboReference
    private UserService userService;

    private final PasswordEncoder pw;

    @Autowired
    public JWTAuthenticationFilter(PasswordEncoder pw) {
        this.pw = pw;
    }


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        log.info("地址[{}]被访问了", request.getRequestURI());

        // 1.从请求头获取token
        String token = request.getHeader("authentication");
        if (token != null) {
            // 2.解析token对应的用户id
            String username = TokenUtil.getUserInfoFromToken(token);
            if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                // 3.解析该用户的权限
                UserDetails userDetails = verifyByUsername(username);
                if (userDetails != null) {
                    UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                    SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                }
            }
        }
        filterChain.doFilter(request, response);
    }

    protected UserDetails verifyByUsername(String username)throws UsernameNotFoundException {
        User user = userService.getByUsername(username);

        System.out.println("user:"+user);
        log.info("用户[{}]发送了校验请求", user.getUsername());

        List<GrantedAuthority> authorityList =
                AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_"+ RoleEnum.getName(user.isAdmin()));

        return new org.springframework.security.core.userdetails.User(user.getUsername(),
                pw.encode(user.getPassword()), authorityList);
    }
}

