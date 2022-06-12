package cn.fuxme.app.platform.controller;

import cn.fuxme.app.platform.model.convert.MenuConvert;
import cn.fuxme.app.platform.model.entity.Menu;
import cn.fuxme.app.platform.model.vo.MenuVO;
import cn.fuxme.app.platform.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 菜单权限表 前端控制器
 * </p>
 *
 * @author wuhao
 * @since 2022-03-27
 */
@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @GetMapping("listByUserId")
    public List<MenuVO> listByUserId(@RequestParam Long userId) {

        List<Menu> menus = menuService.listUserId(userId);
        return MenuConvert.INSTANCE.convertList(menus);
    }
}
