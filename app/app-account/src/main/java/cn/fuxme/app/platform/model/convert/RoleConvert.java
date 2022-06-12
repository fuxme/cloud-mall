package cn.fuxme.app.platform.model.convert;

import cn.fuxme.app.platform.model.entity.Role;
import cn.fuxme.app.platform.model.vo.RoleVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * 角色 Convert
 *
 * @author wuhao
 * @since 2022-03-27
 */
@Mapper
public interface RoleConvert {

    RoleConvert INSTANCE = Mappers.getMapper(RoleConvert.class);

    RoleVO convert(Role role);

    default List<RoleVO> convertList(List<Role> roles) {
        return Optional.ofNullable(roles).orElse(new ArrayList<>()).stream().map(this::convert).collect(Collectors.toList());
    }
}
