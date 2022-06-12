package cn.fuxme.app.platform.model.convert;

import cn.fuxme.app.platform.model.bo.LoginUserBO;
import cn.fuxme.app.platform.model.entity.User;
import cn.fuxme.app.platform.model.vo.UserVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * 用户 Convert
 *
 * @author wuhao
 * @since 2022-03-27
 */
@Mapper
public interface UserConvert {

    UserConvert INSTANCE = Mappers.getMapper(UserConvert.class);

    UserVO convert(User user);

    LoginUserBO convertLoginUserBO(User user);
}
