package cn.fuxme.infra.db.service;

import cn.fuxme.infra.db.mapper.CustomMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * @desc:
 * @author: wuhao
 * @date: 2022/5/9
 **/
public class CustomServiceImpl<M extends CustomMapper<T>, T> extends ServiceImpl<M, T> {
}
