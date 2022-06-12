package cn.fuxme.app.platform.model.convert;

import cn.fuxme.app.platform.model.entity.Menu;
import cn.fuxme.app.platform.model.vo.MenuVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * 菜单权限表 Convert
 *
 * @author wuhao
 * @since 2022-03-27
 */
@Mapper
public interface MenuConvert {

    MenuConvert INSTANCE = Mappers.getMapper(MenuConvert.class);

    MenuVO convert(Menu menu);

    default List<MenuVO> convertList(List<Menu> menus) {
        return Optional.ofNullable(menus).orElse(new ArrayList<>()).stream().map(this::convert).collect(Collectors.toList());
    }

}
