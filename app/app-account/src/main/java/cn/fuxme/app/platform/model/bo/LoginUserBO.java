package cn.fuxme.app.platform.model.bo;

import lombok.Data;

/**
 * @desc: 用于登录
 * @author: wuhao
 * @date: 2022/5/12
 **/
@Data
public class LoginUserBO {

    private Long id;

    private String username;

    private String password;

    /**
     * 帐号状态（1 正常 0 停用）
     */
    private Integer status;
}
