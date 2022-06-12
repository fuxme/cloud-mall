package ${package.Other};

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * ${table.comment!} Convert
 *
 * @author ${author}
 * @since ${date}
 */
@Mapper
public interface ${entity}Convert {

    ${entity}Convert INSTANCE = Mappers.getMapper(${entity}Convert.class);

}
