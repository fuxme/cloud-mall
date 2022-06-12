package cn.fuxme.app.platform.service.impl;

import cn.fuxme.app.platform.mapper.RoleMapper;
import cn.fuxme.app.platform.model.entity.Role;
import cn.fuxme.app.platform.service.RoleService;
import cn.fuxme.infra.db.service.CustomServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色 服务实现类
 * </p>
 *
 * @author wuhao
 * @since 2022-03-27
 */
@Service
public class RoleServiceImpl extends CustomServiceImpl<RoleMapper, Role> implements RoleService {

}
