package cn.fuxme.app.gateway.auth.model;

import lombok.Data;

/**
 * @desc:
 * @author: wuhao
 * @date: 2022/5/11
 **/
@Data
public class RoleVO {
    /**
     * 角色名称
     */
    private String name;

    /**
     * 角色权限编码
     */
    private String code;
}
