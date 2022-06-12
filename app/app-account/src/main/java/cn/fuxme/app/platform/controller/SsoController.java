package cn.fuxme.app.platform.controller;

import cn.dev33.satoken.sso.SaSsoHandle;
import cn.dev33.satoken.stp.StpUtil;
import cn.fuxme.app.platform.model.entity.User;
import cn.fuxme.app.platform.model.form.LoginForm;
import cn.fuxme.app.platform.model.vo.LoginResultVO;
import cn.fuxme.app.platform.model.vo.UserInfoVO;
import cn.fuxme.app.platform.service.IUserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @desc: SSO Controller
 * @author: wuhao
 * @date: 2022/5/11
 **/

@RestController
@RequestMapping("/account/sso")
public class SsoController {

    @Autowired
    private IUserService userService;

    /**
     * 登录
     * @param form
     * @return
     */
    @PostMapping("/login")
    public LoginResultVO ssoAuth(@RequestBody LoginForm form) {
        LoginResultVO result = new LoginResultVO();
        User user = userService.getOne(new QueryWrapper<User>().eq("username", form.getUsername()));
        if (null != user
                && Integer.valueOf(1).equals(user.getStatus())
                && form.getPassword().equals(user.getPassword())) {
            StpUtil.login(user.getId());
            result.setSuccess(true);
            result.setTokenName(StpUtil.getTokenName());
            result.setTokenValue(StpUtil.getTokenValue());

        } else {
            result.setSuccess(false);
        }
        return result;
    }

    /**
     * 获取用户信息
     * @return
     */
    @GetMapping("/userInfo")
    public UserInfoVO getUserInfo() {
        Long userId = StpUtil.getLoginIdAsLong();
        User user = userService.getById(userId);

        UserInfoVO userInfo = new UserInfoVO();
        userInfo.setUsername(user.getUsername());
//        userInfo.setAvatar();
//        userInfo.setMenus();

        return userInfo;
    }

    /**
     *
     * @return
     */
    @RequestMapping("/logout")
    public Object ssoLogout() {
        StpUtil.logout();
        return SaSsoHandle.ssoLogoutByUserVisit();
    }

}

