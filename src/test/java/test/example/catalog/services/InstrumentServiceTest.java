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
@DisplayName("ギターの一覧を取得　条件:ブランドID")
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

@DisplayName("ギターの一覧を取得　条件:ブランドID 該当なし")
@Test
void test002(){
    SearchCondition condition = new SearchCondition();
    condition.setBrandId("99");

    List<Instrument> insts = instrumentService.getInst(condition);
    assertThat(insts.size()).isEqualTo(0);
    {
    }
}

@DisplayName("ギターの一覧を取得　条件:完全一致")
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
@DisplayName("ギターの一覧を取得　条件:部分一致")
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

@DisplayName("ギターの一覧を取得　条件:ブランドID　該当なし")
@Test
void test005(){
    SearchCondition condition = new SearchCondition();
    condition.setKeyword("存在しないギター");

    List<Instrument> insts = instrumentService.getInst(condition);
    assertThat(insts.size()).isEqualTo(0);
    {
    }
}

@DisplayName("ギターの一覧を取得　条件ブランドID, バイク名")
@ParameterizedTest
@CsvSource({"01,Strato,Stratocaster","01,Telecas,Telecaster","02,Paul,Les Paul"})
void test006(String brandId ,String keyword,String name){
    SearchCondition condition = new SearchCondition();
    condition.setBrandId(brandId);
    condition.setKeyword(keyword);

    List<Instrument> insts = instrumentService.getInst(condition);
    assertThat(insts.size()).isGreaterThanOrEqualTo(1);
    for(Instrument inst : insts){
        assertThat(inst.getName()).startsWith(name);
    }
}
@DisplayName("ギターの一覧を取得　条件:ブランドID,バイク名 該当なし")
@ParameterizedTest
@CsvSource({"01,Stra77","02,Paul5"})
void test007(String brandId ,String keyword){
    SearchCondition condition = new SearchCondition();
    condition.setBrandId(brandId);
    condition.setKeyword(keyword);

    List<Instrument> insts = instrumentService.getInst(condition);
    assertThat(insts.size()).isEqualTo(0);
    {
    }
}
@DisplayName("ギターの一覧を取得　条件:なし 全件該当")
@Test
void test008(){
    SearchCondition condition = new SearchCondition();

    List<Instrument> insts = instrumentService.getInst(condition);
    assertThat(insts.size()).isEqualTo(5);
    {
    }
}
@DisplayName("ギターの一覧を取得　条件:ID")
@ParameterizedTest
@CsvSource({"01,Stratocaster","02,Les Paul"})
void test009(Integer id ,String name){

    Instrument inst = instrumentService.getId(id);
    assertThat(inst.getName()).isEqualTo(name);
    {
    }
}
}
