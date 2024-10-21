package test.example.catalog.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.slf4j.Slf4j;
import test.example.catalog.beans.Brand;
import test.example.catalog.beans.Instrument;
import test.example.catalog.beans.SearchCondition;
import test.example.catalog.services.InstrumentService;

@Slf4j
@Controller
public class CatalogController {

    @Autowired
    InstrumentService instrumentService;

    @RequestMapping("/hello")
    public String hello(@RequestParam String name, Model model) {
        model.addAttribute("name", name);
        return "hello";
    }

    @GetMapping("/inst")
    public String inst(Model model) {
        SearchCondition condition = new SearchCondition();
        List<Brand> brands = new ArrayList<>();
        // brands.add(new Brand("1", "ギブソン"));
        // brands.add(new Brand("2", "SPR"));
        // brands.add(new Brand("3", "グレッチ"));

        List<Instrument> instruments = new ArrayList<>();

        // instruments.add(new Instrument(1,"1", "ハミングバード","木", "?", 10000, "よい", null,
        // null));
        // instruments.add(new Instrument(2,"2", "ハミングバード2","木", "?", 103000, "めっちゃよい",
        // null, null));
        // instruments.add(new Instrument(3,"3", "Gretsch G5655TG Electromatic","木",
        // "?", 1555000, "おそらくよい", null, null));


        model.addAttribute("brands", instrumentService.getBrands());
        model.addAttribute("instruments", instrumentService.getInst(condition));

        log.debug("instruments: {}", instruments);
        return "inst_catalog_list";
    }

}
