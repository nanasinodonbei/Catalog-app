package test.example.catalog.controllers;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.slf4j.Slf4j;
import test.example.catalog.bean.Brand;
import test.example.catalog.bean.Instrument;

@Slf4j
@Controller
public class CatalogController {

    @RequestMapping("/hello")
    public String hello(@RequestParam String name, Model model) {
        model.addAttribute("name", name);
        return "hello";
    }
        @GetMapping("/inst")
        public String inst(Model model) {
            List<Brand> brands = new ArrayList<>();
            brands.add(new Brand("1", "ギブソン")); 
            brands.add(new Brand("2", "SPR")); 
            brands.add(new Brand("3", "グレッチ")); 
        
            List<Instrument> instruments = new ArrayList<>();
            instruments.add(new Instrument(1, "ハミングバード", "ギブソン","木", "?", 10000, "よい", null, null)); 
            instruments.add(new Instrument(2, "ハミングバード2", "レスポール","木", "?", 103000, "めっちゃよい", null, null)); 
            instruments.add(new Instrument(3, "Gretsch G5655TG Electromatic", "グレッチ","木", "?", 1555000, "おそらくよい", null, null)); 

            // モデルにブランドと楽器を追加することを考慮
            model.addAttribute("brands", brands);
            model.addAttribute("instruments", instruments);
        
            log.debug("instruments: {}", instruments);
            return "inst_catalog_list";
        }
        
    }

