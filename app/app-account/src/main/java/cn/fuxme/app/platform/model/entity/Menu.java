package cn.fuxme.app.platform.model.entity;

import cn.fuxme.infra.db.entity.BaseEntity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * <p>
 * 菜单权限表
 * </p>
 *
 * @author wuhao
 * @since 2022-03-27
 */
@Getter
@Setter
@TableName("platform_menu")
public class Menu extends BaseEntity {

    /**
     * 菜单ID
     */
    @TableId(value = "id", type = IdType.AUTO)
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

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;


}
