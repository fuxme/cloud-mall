package cn.fuxme.app.gateway.auth.feign;

import cn.fuxme.app.gateway.auth.model.MenuVO;
import cn.fuxme.app.gateway.auth.model.RoleVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @desc:
 * @author: wuhao
 * @date: 2022/5/12
 **/
@FeignClient(value = "app-account")
public interface PlatformFeign {

    @GetMapping("/role/getByUserId")
    List<RoleVO> getRolesByUserId(@RequestParam("userId") Long userId);


    @GetMapping("/menu/listByUserId")
    List<MenuVO> listMenuByUserId(@RequestParam("userId") Long userId);
}
