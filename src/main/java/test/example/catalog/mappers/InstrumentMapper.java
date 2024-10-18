package test.example.catalog.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import test.example.catalog.beans.Instrument;
import test.example.catalog.beans.SearchCondition;

@Mapper
public interface InstrumentMapper {

    /**
     * ギターの情報を検索する
     * 
     * @param condition
     * @return
     */
    public List<Instrument> selectByCondition(SearchCondition condition);

    /**
     * 主キーで検索をする
     * 
     * @param id ギターID
     * @return　ギター情報
     */
    public List<Instrument> selectById(int id);

}