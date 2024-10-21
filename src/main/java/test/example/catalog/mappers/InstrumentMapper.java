package test.example.catalog.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

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
     * @return ギター情報
     */
    public Instrument selectById(int id);

    /**
     * @param inst ギター情報
     * @return 更新件数
     */
    @Update("UPDATE instruments SET brand_id = #{brand.brandId}, name = #{name}, material = #{material}, body = #{body}, price = #{price}, comment = #{comment}, `insDt` = #{insDt}, `updDt` = #{updDt} WHERE id = #{id}")
    public int update(Instrument inst);

}


