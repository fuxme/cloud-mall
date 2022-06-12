package cn.fuxme.app.platform.service;

import cn.fuxme.app.platform.model.entity.Menu;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 菜单权限表 服务类
 * </p>
 *
 * @author wuhao
 * @since 2022-03-27
 */
public interface MenuService extends IService<Menu> {

    List<Menu> listUserId(Long userId);
}
