package cn.fuxme.app.gateway.auth.service.impl;

import cn.dev33.satoken.stp.StpInterface;
import cn.fuxme.app.gateway.auth.feign.PlatformFeign;
import cn.fuxme.app.gateway.auth.model.MenuVO;
import cn.fuxme.app.gateway.auth.model.RoleVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @desc: 鉴权
 * @author: wuhao
 * @date: 2022/5/11
 **/
@Component
public class AuthServiceImpl implements StpInterface {

    @Autowired
    private PlatformFeign platformFeign;

    @Override
    public List<String> getPermissionList(Object loginId, String loginType) {
        List<MenuVO> menus = platformFeign.listMenuByUserId((Long) loginId);
        return menus.stream().map(MenuVO::getPermission).collect(Collectors.toList());
    }

    @Override
    public List<String> getRoleList(Object loginId, String loginType) {
        List<RoleVO> roles = platformFeign.getRolesByUserId((Long) loginId);
        return roles.stream().map(RoleVO::getName).collect(Collectors.toList());
    }
}
