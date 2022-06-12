package cn.fuxme.app.gateway.auth.config;

import cn.dev33.satoken.reactor.filter.SaReactorFilter;
import cn.dev33.satoken.router.SaRouter;
import cn.dev33.satoken.stp.StpUtil;
import cn.fuxme.app.gateway.filter.AuthFilter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @desc: 鉴权管理器
 * @author: wuhao
 * @date: 2022/5/11
 **/
@Configuration
@Slf4j
public class AuthFilterConfig {
    @Bean
    public SaReactorFilter getSaReactorFilter() {
        return new AuthFilter()
                // 拦截地址
                .addInclude("/**")
                // 开放地址
//                .addExclude("/favicon.ico")
                // 鉴权方法：每次访问进入
                .setAuth(auth -> {
                    // 登录校验 -- 拦截所有路由，并排除/user/doLogin 用于开放登录
                    SaRouter.match("/**", "/sso/login", r -> StpUtil.checkLogin());

                    // 权限认证 -- 不同模块, 校验不同权限
                    SaRouter.match("/user/**", r -> StpUtil.checkPermission("user"));
                    SaRouter.match("/admin/**", r -> StpUtil.checkPermission("admin"));
                    SaRouter.match("/goods/**", r -> StpUtil.checkPermission("goods"));
                    SaRouter.match("/orders/**", r -> StpUtil.checkPermission("orders"));

                    // ...
                })
                // 异常处理方法：每次setAuth函数出现异常时进入
                .setError(e -> {
                    log.error("鉴权异常", e);
                    return e;
                })
                ;
    }
}
