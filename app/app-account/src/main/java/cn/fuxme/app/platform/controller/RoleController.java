package cn.fuxme.app.platform.controller;

import cn.fuxme.app.platform.model.convert.RoleConvert;
import cn.fuxme.app.platform.model.entity.Role;
import cn.fuxme.app.platform.model.vo.RoleVO;
import cn.fuxme.app.platform.service.RoleService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 角色 前端控制器
 * </p>
 *
 * @author wuhao
 * @since 2022-03-27
 */
@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @GetMapping("/getByUserId")
    public List<RoleVO> getRolesByUserId(@RequestParam Long userId) {
        List<Role> roles = roleService.list(new QueryWrapper<Role>().eq("userId", userId));
        return RoleConvert.INSTANCE.convertList(roles);
    }

}
