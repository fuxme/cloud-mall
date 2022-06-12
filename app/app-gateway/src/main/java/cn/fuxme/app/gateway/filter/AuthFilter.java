package cn.fuxme.app.gateway.filter;

import cn.dev33.satoken.exception.BackResultException;
import cn.dev33.satoken.exception.NotLoginException;
import cn.dev33.satoken.exception.NotPermissionException;
import cn.dev33.satoken.exception.StopMatchException;
import cn.dev33.satoken.reactor.context.SaReactorHolder;
import cn.dev33.satoken.reactor.context.SaReactorSyncHolder;
import cn.dev33.satoken.reactor.filter.SaReactorFilter;
import cn.dev33.satoken.router.SaRouter;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

/**
 * @desc: 简单修改了 SaReactorFilter filter 异常时的响应数据
 * @author: wuhao
 * @date: 2022/5/14
 **/
public class AuthFilter extends SaReactorFilter {

    /**
     * 拦截路由
     */
    private List<String> includeList = new ArrayList<>();

    /**
     * 放行路由
     */
    private List<String> excludeList = new ArrayList<>();

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {

        // 写入WebFilterChain对象
        exchange.getAttributes().put(SaReactorHolder.CHAIN_KEY, chain);

        // ---------- 全局认证处理
        try {
            // 写入全局上下文 (同步)
            SaReactorSyncHolder.setContext(exchange);

            // 执行全局过滤器
            SaRouter.match(includeList).notMatch(excludeList).check(r -> {
                beforeAuth.run(null);
                auth.run(null);
            });

        } catch (StopMatchException e) {

        } catch (Throwable e) {
            // 1. 获取异常处理策略结果
            Object run = error.run(e);
            HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
            String result = "未知异常";

            // 2. 写入输出流
            ServerHttpResponse response = exchange.getResponse();
            if(exchange.getResponse().getHeaders().getFirst("Content-Type") == null) {
                response.getHeaders().set("Content-Type", "application/json; charset=utf-8");
            }
            if (e instanceof BackResultException) {
                status = HttpStatus.OK;
                result = e.getMessage();
            } else if (e instanceof NotLoginException) {
                status = HttpStatus.UNAUTHORIZED;
                result = "请登录";
            } else if (e instanceof NotPermissionException) {
                status = HttpStatus.FORBIDDEN;
                result = "权限不足";
            }
            response.setStatusCode(status);
            return exchange.getResponse().writeWith(Mono.just(exchange.getResponse().bufferFactory().wrap(result.getBytes())));

        } finally {
            // 清除上下文
            SaReactorSyncHolder.clearContext();
        }

        // ---------- 执行

        // 写入全局上下文 (同步)
        SaReactorSyncHolder.setContext(exchange);

        // 执行
        return chain.filter(exchange).subscriberContext(ctx -> {
            // 写入全局上下文 (异步)
            ctx = ctx.put(SaReactorHolder.CONTEXT_KEY, exchange);
            return ctx;
        }).doFinally(r -> {
            // 清除上下文
            SaReactorSyncHolder.clearContext();
        });
    }
}
