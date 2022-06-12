package cn.fuxme.infra.db.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * @desc: 继承 Mybatis plus 的 BaseMapper，以便于后期扩展
 * @author: wuhao
 * @date: 2022/5/9
 **/
public interface CustomMapper<T> extends BaseMapper<T> {
}
