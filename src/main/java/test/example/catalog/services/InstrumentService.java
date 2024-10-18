package test.example.catalog.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import test.example.catalog.beans.Brand;
import test.example.catalog.beans.Instrument;
import test.example.catalog.beans.SearchCondition;
import test.example.catalog.beans.SearchCondition;
import test.example.catalog.mappers.BrandMapper;
import test.example.catalog.mappers.InstrumentMapper;

@Service
public class InstrumentService {

    @Autowired
    InstrumentMapper instrumentMapper;

    @Autowired
    BrandMapper brandMapper;

    public List<Instrument> getInst(SearchCondition condition) {
        return instrumentMapper.selectByCondition(condition);
    }
    public List<Instrument> getInst(int id) {
        return instrumentMapper.selectById(id);
    }

    public List<Brand> getBrands(){
        return brandMapper.selectAll();
    }
}
