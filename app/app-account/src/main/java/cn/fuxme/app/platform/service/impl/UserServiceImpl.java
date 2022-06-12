package cn.fuxme.app.platform.service.impl;

import cn.fuxme.app.platform.mapper.UserMapper;
import cn.fuxme.app.platform.model.entity.User;
import cn.fuxme.app.platform.service.IUserService;
import cn.fuxme.infra.db.service.CustomServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户 服务实现类
 * </p>
 *
 * @author wuhao
 * @since 2022-03-27
 */
@Service
public class UserServiceImpl extends CustomServiceImpl<UserMapper, User> implements IUserService {

}
