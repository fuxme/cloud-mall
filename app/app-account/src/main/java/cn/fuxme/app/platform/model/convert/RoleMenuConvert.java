package cn.fuxme.app.platform.model.convert;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * 角色和菜单关联表 Convert
 *
 * @author wuhao
 * @since 2022-03-27
 */
@Mapper
public interface RoleMenuConvert {

    RoleMenuConvert INSTANCE = Mappers.getMapper(RoleMenuConvert.class);

}
