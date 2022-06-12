package cn.fuxme.app.platform.service.impl;

import cn.fuxme.app.platform.mapper.RoleMenuMapper;
import cn.fuxme.app.platform.model.entity.RoleMenu;
import cn.fuxme.app.platform.service.IRoleMenuService;
import cn.fuxme.infra.db.service.CustomServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色和菜单关联表 服务实现类
 * </p>
 *
 * @author wuhao
 * @since 2022-03-27
 */
@Service
public class RoleMenuServiceImpl extends CustomServiceImpl<RoleMenuMapper, RoleMenu> implements IRoleMenuService {

}
