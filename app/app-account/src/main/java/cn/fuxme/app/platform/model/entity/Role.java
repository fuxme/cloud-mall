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
 * 角色
 * </p>
 *
 * @author wuhao
 * @since 2022-03-27
 */
@Getter
@Setter
@TableName("platform_role")
public class Role extends BaseEntity {

    /**
     * 角色ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 角色名称
     */
    private String name;

    /**
     * 角色权限编码
     */
    private String code;

    /**
     * 显示顺序
     */
    private Integer seq;

    /**
     * 数据范围（1：全部数据权限 2：自定数据权限 3：本部门数据权限 4：本部门及以下数据权限）
     */
    private Integer dataScope;

    /**
     * 数据范围(指定部门数组)
     */
    private String dataScopeDeptIds;

    /**
     * 角色状态（1 正常 0 停用）
     */
    private Integer status;

    /**
     * 角色类型
     */
    private Integer type;

    /**
     * 备注
     */
    private String remark;

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
