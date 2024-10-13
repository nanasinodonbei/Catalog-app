package test.example.catalog.services;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import test.example.catalog.beans.Instrument;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class InstrumentServiceTest {

    @Autowired
    InstrumentService instrumentService;
    
    @Test
    void ギターの情報を全件検索する(){
        List<Instrument> inst = instrumentService.getInst();

        assertThat(inst.size()).isEqualTo(5);

        Instrument instrument = inst.get(0);
        assertThat(instrument).isNotNull();
        assertThat(instrument.getId()).isEqualTo(1);
        assertThat(instrument.getPrice()).isEqualTo(120000);
        assertThat(instrument.getBrand().getBrandName()).isEqualTo("Fender");
    }
}
