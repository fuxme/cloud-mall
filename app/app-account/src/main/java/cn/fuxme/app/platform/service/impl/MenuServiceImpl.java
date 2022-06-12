package cn.fuxme.app.platform.service.impl;

import cn.fuxme.app.platform.mapper.MenuMapper;
import cn.fuxme.app.platform.mapper.RoleMapper;
import cn.fuxme.app.platform.mapper.RoleMenuMapper;
import cn.fuxme.app.platform.model.entity.Menu;
import cn.fuxme.app.platform.model.entity.Role;
import cn.fuxme.app.platform.model.entity.RoleMenu;
import cn.fuxme.app.platform.service.MenuService;
import cn.fuxme.infra.db.service.CustomServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * <p>
 * 菜单权限表 服务实现类
 * </p>
 *
 * @author wuhao
 * @since 2022-03-27
 */
@Service
public class MenuServiceImpl extends CustomServiceImpl<MenuMapper, Menu> implements MenuService {

    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private RoleMenuMapper roleMenuMapper;
    @Autowired
    private MenuMapper menuMapper;

    @Override
    public List<Menu> listUserId(Long userId) {
        List<Role> roles = roleMapper.selectList(new QueryWrapper<Role>().eq("userId", userId));
        List<Long> roleIds = roles.stream().map(Role::getId).collect(Collectors.toList());
        List<RoleMenu> roleMenus = roleMenuMapper.selectList(new QueryWrapper<RoleMenu>().in("roleId", roleIds));
        Set<Long> menuIds = roleMenus.stream().map(RoleMenu::getMenuId).collect(Collectors.toSet());
        return menuMapper.selectList(new QueryWrapper<Menu>().in("id", menuIds));
    }
}
