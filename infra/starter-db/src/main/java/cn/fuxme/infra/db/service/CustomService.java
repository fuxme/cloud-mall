package cn.fuxme.infra.db.service;

import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @desc: 继承 Mybatis plus 的 IService，以便于后期扩展
 * @author: wuhao
 * @date: 2022/5/9
 **/
public interface CustomService<T> extends IService<T> {
}
