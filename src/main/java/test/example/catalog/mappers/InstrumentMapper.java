package test.example.catalog.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import test.example.catalog.beans.Instrument;

@Mapper
public interface InstrumentMapper {

    /**
     * ギターの情報を全件検索する
     * 
     * @return
     */
    public List<Instrument> selectAll();
}