package cn.fuxme.app.platform.controller;

import cn.fuxme.app.platform.model.bo.LoginUserBO;
import cn.fuxme.app.platform.model.convert.UserConvert;
import cn.fuxme.app.platform.model.entity.User;
import cn.fuxme.app.platform.model.vo.UserVO;
import cn.fuxme.app.platform.service.IUserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * <p>
 * 用户 前端控制器
 * </p>
 *
 * @author wuhao
 * @since 2022-03-27
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping("{id}")
    public UserVO getById(@PathVariable Long id) {
        User user = userService.getById(id);
        return UserConvert.INSTANCE.convert(user);
    }

    @GetMapping("list")
    public List<UserVO> listAll() {
        List<User> user = Optional.ofNullable(userService.list()).orElse(new ArrayList<>());
        return user.stream().map(UserConvert.INSTANCE::convert).collect(Collectors.toList());
    }

    @GetMapping("/getLoginUserByUsername")
    public LoginUserBO getLoginUserByUsername(@RequestParam String username) {
        User user = userService.getOne(new QueryWrapper<User>().eq("username", username));
        return UserConvert.INSTANCE.convertLoginUserBO(user);
    }

}
