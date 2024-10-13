package test.example.catalog.mappers;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

import test.example.catalog.beans.Brand;

@Mapper
public interface BrandMapper {

    public List<Brand> selectAll();
    
} 