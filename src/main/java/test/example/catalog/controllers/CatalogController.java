package test.example.catalog.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.slf4j.Slf4j;
import test.example.catalog.beans.SearchForm;
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
public String inst(@ModelAttribute("searchForm") SearchForm searchForm, Model model) {
    
    if (searchForm == null) {
        searchForm = new SearchForm();
    }

    log.info("検索条件: {}", searchForm);

    model.addAttribute("brands", instrumentService.getBrands());
    model.addAttribute("instruments", instrumentService.getInst(searchForm));

    log.debug("抽出結果: {}", model);
    return "inst_catalog_list";
}

}
