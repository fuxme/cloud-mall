package cn.fuxme.app.platform.model.vo;

import lombok.Data;

import java.util.List;

/**
 * @desc:
 * @author: wuhao
 * @date: 2022/5/24
 **/
@Data
public class UserInfoVO {

    private String username;

    private String avatar;

    private List<String> menus;
}
