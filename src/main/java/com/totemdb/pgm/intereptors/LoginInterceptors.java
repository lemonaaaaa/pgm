package com.totemdb.pgm.intereptors;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.totemdb.pgm.utils.JwtUtil;
import com.totemdb.pgm.utils.ThreadLocalUtil;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.Map;

@Component
public class LoginInterceptors implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //令牌验证
        String token = request.getHeader("Authorization");
        try {
            Map<String,Object> claims = JwtUtil.parseToken(token);
            //业务数据存储到ThreadLocal对象中
            ThreadLocalUtil.set(claims);
            return true;//放行
        } catch (Exception e) {
            //HTTP响应状态码为401
            response.setStatus(401);
            return false;//不放行
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        //清空ThreadLocal中的数据，防止内存泄露
        ThreadLocalUtil.remove();
    }
}
