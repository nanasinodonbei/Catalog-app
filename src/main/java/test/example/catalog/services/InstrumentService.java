package test.example.catalog.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import test.example.catalog.beans.Brand;
import test.example.catalog.beans.Instrument;
import test.example.catalog.beans.SearchForm;
import test.example.catalog.beans.SearchForm;
import test.example.catalog.mappers.BrandMapper;
import test.example.catalog.mappers.InstrumentMapper;

@Service
public class InstrumentService {

    @Autowired
    InstrumentMapper instrumentMapper;

    @Autowired
    BrandMapper brandMapper;

    public List<Instrument> getInst(SearchForm condition) {
        return instrumentMapper.selectByCondition(condition);
    }
    public Instrument getInst(int id) {
        return instrumentMapper.selectById(id);
    }

    public List<Brand> getBrands(){
        return brandMapper.selectAll();
    }

    public int save (Instrument inst){

        return instrumentMapper.update(inst);
    }
}
