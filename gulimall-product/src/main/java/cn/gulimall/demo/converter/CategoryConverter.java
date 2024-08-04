package cn.gulimall.demo.converter;

import cn.gulimall.demo.model.dto.PmsCategoryDto;
import cn.gulimall.demo.model.po.PmsCategory;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

/**
 * @author Z
 * @since 2024/8/4 下午8:43
 */
@Mapper
public interface CategoryConverter {

    CategoryConverter INSTANCE = Mappers.getMapper(CategoryConverter.class);

    @Mappings({
            @Mapping(source = "catId", target = "catId"),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "parentCid", target = "parentCid"),
            @Mapping(source = "showStatus", target = "showStatus"),
            @Mapping(source = "sort", target = "sort"),
            @Mapping(source = "icon", target = "icon"),
            @Mapping(source = "productUnit", target = "productUnit"),
            @Mapping(source = "productCount", target = "productCount"),
            @Mapping(target = "catLevel", ignore = true)
    })
    PmsCategory toPo(PmsCategoryDto dto);


}
