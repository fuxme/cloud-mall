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
 * 角色和菜单关联表
 * </p>
 *
 * @author wuhao
 * @since 2022-03-27
 */
@Getter
@Setter
@TableName("platform_role_menu")
public class RoleMenu extends BaseEntity {

    /**
     * 自增编号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 角色ID
     */
    private Long roleId;

    /**
     * 菜单ID
     */
    private Long menuId;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 租户编号
     */
    private Long tenantId;


}
