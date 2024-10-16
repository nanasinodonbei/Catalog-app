package test.example.catalog.services;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import test.example.catalog.beans.Instrument;
import test.example.catalog.beans.SearchCondition;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class InstrumentServiceTest {

    @Autowired
    InstrumentService instrumentService;
    
//     @Test
//     void ギターの情報を全件検索する(){
//         SearchCondition condition = new SearchCondition();
//         List<Instrument> inst = instrumentService.getInst(condition);

//         assertThat(inst.size()).isEqualTo(5);

//         Instrument instrument = inst.get(0);
//         assertThat(instrument).isNotNull();
//         assertThat(instrument.getId()).isEqualTo(1);
//         assertThat(instrument.getPrice()).isEqualTo(120000);
//         assertThat(instrument.getBrand().getBrandName()).isEqualTo("Fender");
//    }
@DisplayName("ギターの除法を取得　条件:brandID")
@ParameterizedTest
@CsvSource({"01,Fender","02,Gibson","03,Ibanez"})
void test001(String brandId,String brandName){
    SearchCondition condition = new SearchCondition();
    condition.setBrandId(brandId);

    List<Instrument> insts = instrumentService.getInst(condition);
    assertThat(insts.size()).isGreaterThanOrEqualTo(1);
    for(Instrument inst : insts){
        assertThat(inst.getBrand().getBrandName()).isEqualTo(brandName);
    }
}

@DisplayName("ギターの除法を取得　条件:ID 該当なし")
@Test
void test002(){
    SearchCondition condition = new SearchCondition();
    condition.setBrandId("99");

    List<Instrument> insts = instrumentService.getInst(condition);
    assertThat(insts.size()).isEqualTo(0);
    {
    }
}

@DisplayName("ギターの除法を取得　条件:完全一致")
@ParameterizedTest
@CsvSource({"Stratocaster","Les Paul","Telecaster"})
void test003(String name){
    SearchCondition condition = new SearchCondition();
    condition.setKeyword(name);

    List<Instrument> insts = instrumentService.getInst(condition);
    assertThat(insts.size()).isGreaterThanOrEqualTo(1);
    for(Instrument inst : insts){
        assertThat(inst.getName()).isEqualTo(name);
    }
}
@DisplayName("ギターの除法を取得　条件:部分一致")
@ParameterizedTest
@CsvSource({"Strato,Stratocaster","Telecas,Telecaster","Paul,Les Paul"})
void test004(String keyword,String name){
    SearchCondition condition = new SearchCondition();
    condition.setKeyword(keyword);

    List<Instrument> insts = instrumentService.getInst(condition);
    assertThat(insts.size()).isGreaterThanOrEqualTo(1);
    for(Instrument inst : insts){
        assertThat(inst.getName()).isEqualTo(name);
    }
}
}
