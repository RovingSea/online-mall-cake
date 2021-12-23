package com.wu.auth.config.security;

import com.wu.common.domain.User;
import com.wu.common.domain.enums.RoleEnum;
import com.wu.common.service.user.UserService;
import com.wu.common.utility.http.SystemCode;
import com.wu.common.utility.util.RedisUtil;
import com.wu.common.utility.util.RestUtil;
import com.wu.common.utility.util.TokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.common.utils.StringUtils;
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
 * @date 2021/12/17 22:12
 * @since 1.0
 */
@Component
@Slf4j
public class JWTAuthenticationFilter extends OncePerRequestFilter {

    @DubboReference
    private UserService userService;

    private final PasswordEncoder pw;
    private final RedisUtil redisUtil;
    private final static String USER_TOKEN = "omc:user:token::";

    @Autowired
    public JWTAuthenticationFilter(PasswordEncoder pw, RedisUtil redisUtil) {
        this.pw = pw;
        this.redisUtil = redisUtil;
    }


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        log.info("地址[{}]被[{}]访问了", request.getRequestURI(), getIpAddress(request));

        // 1.从请求头获取token
        String token = request.getHeader("authentication");
        if (token != null) {
            // 2.解析token对应的用户id
            String username = TokenUtil.getUserInfoFromToken(token);
            if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                // 3.如果token过期
                if (!redisUtil.hasKey(USER_TOKEN+username) | redisUtil.getExpire(USER_TOKEN+username) == -1){
                    RestUtil.response(response, SystemCode.AccessTokenError);
                    return;
                }
                // 4.解析该用户的权限
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
                AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_"+ RoleEnum.getName(user.getIsAdmin()));

        return new org.springframework.security.core.userdetails.User(user.getUsername(),
                pw.encode(user.getPassword()), authorityList);
    }

    protected String getIpAddress(HttpServletRequest request){
        String Xip = request.getHeader("X-Real-IP");
        String XFor = request.getHeader("X-Forwarded-For");
        if(StringUtils.isNotEmpty(XFor) && !"unKnown".equalsIgnoreCase(XFor)){
            //多次反向代理后会有多个ip值，第一个ip才是真实ip
            int index = XFor.indexOf(",");
            if(index != -1){
                return XFor.substring(0,index);
            }else{
                return XFor;
            }
        }
        XFor = Xip;
        if(StringUtils.isNotEmpty(XFor) && !"unKnown".equalsIgnoreCase(XFor)){
            return XFor;
        }
        if (StringUtils.isBlank(XFor) || "unknown".equalsIgnoreCase(XFor)) {
            XFor = request.getHeader("Proxy-Client-IP");
        }
        if (StringUtils.isBlank(XFor) || "unknown".equalsIgnoreCase(XFor)) {
            XFor = request.getHeader("WL-Proxy-Client-IP");
        }
        if (StringUtils.isBlank(XFor) || "unknown".equalsIgnoreCase(XFor)) {
            XFor = request.getHeader("HTTP_CLIENT_IP");
        }
        if (StringUtils.isBlank(XFor) || "unknown".equalsIgnoreCase(XFor)) {
            XFor = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (StringUtils.isBlank(XFor) || "unknown".equalsIgnoreCase(XFor)) {
            XFor = request.getRemoteAddr();
        }
        return XFor;
    }
}

