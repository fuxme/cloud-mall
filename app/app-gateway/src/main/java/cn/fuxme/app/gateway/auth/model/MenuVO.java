package cn.fuxme.app.gateway.auth.model;

import lombok.Data;

/**
 * @desc:
 * @author: wuhao
 * @date: 2022/5/12
 **/
@Data
public class MenuVO {
    private Long id;

    /**
     * 菜单名称
     */
    private String name;

    /**
     * 权限标识
     */
    private String permission;

    /**
     * 菜单类型（MENU 目录 CARTE 菜单 BUTTON 按钮）
     */
    private String menuType;

    /**
     * 显示顺序
     */
    private Integer seq;

    /**
     * 父菜单ID
     */
    private Long parentId;

    /**
     * 路由地址
     */
    private String path;

    /**
     * 菜单图标
     */
    private String icon;

    /**
     * 组件路径
     */
    private String component;

    /**
     * 菜单状态（1 正常 0 停用）
     */
    private Integer status;

}
