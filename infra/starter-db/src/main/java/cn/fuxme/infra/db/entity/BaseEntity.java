package cn.fuxme.infra.db.entity;

import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @desc:
 * @author: wuhao
 * @date: 2022/3/26
 **/
@Data
public class BaseEntity {

    /**
     * 租户编号
     */
    private Long tenantId;

    /**
     * 创建者
     */
    private String creator;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新者
     */
    private String updater;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 是否删除
     */
    @TableLogic
    private Boolean deleted;

}
