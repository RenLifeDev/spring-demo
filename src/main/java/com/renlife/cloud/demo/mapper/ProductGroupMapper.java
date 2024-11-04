package com.renlife.cloud.demo.mapper;

import com.renlife.cloud.demo.persistence.entity.ProductEntity;
import com.renlife.cloud.demo.persistence.entity.ProductGroupEntity;
import com.renlife.cloud.demo.web.dto.ProductDto;
import com.renlife.cloud.demo.web.dto.ProductGroupDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface ProductGroupMapper {

    ProductGroupMapper INSTANCE = Mappers.getMapper(ProductGroupMapper.class);

    List<ProductGroupDto> toModelList(List<ProductGroupEntity> all);

    List<ProductDto> toProducts(List<ProductEntity> entity);

    ProductDto toProduct(ProductEntity entity);
}
