package test.example.catalog.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import test.example.catalog.beans.Instrument;
import test.example.catalog.mappers.InstrumentMapper;

@Service
public class InstrumentService {

    @Autowired
    InstrumentMapper instrumentMapper;

    public List<Instrument> getInst() {
        // instrumentMapperを使ってselectAll()を呼び出す
        return instrumentMapper.selectAll();
    }
}
