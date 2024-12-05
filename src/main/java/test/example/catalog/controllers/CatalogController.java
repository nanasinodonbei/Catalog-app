package test.example.catalog.controllers;

import java.time.LocalDateTime;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.slf4j.Slf4j;
import test.example.catalog.beans.SearchForm;
import test.example.catalog.forms.InstFrom;
import test.example.catalog.services.InstrumentService;
import test.example.catalog.beans.Instrument;

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
    public String inst(@Validated SearchForm searchForm, BindingResult result, Model model) {

        if (searchForm == null) {
            searchForm = new SearchForm();

        } else if (result.hasErrors()) {

            return "inst_catalog_list";
        }

        log.info("検索条件: {}", searchForm);

        model.addAttribute("brands", instrumentService.getBrands());
        model.addAttribute("instruments", instrumentService.getInst(searchForm));
        model.addAttribute("datetime", LocalDateTime.now());

        log.debug("抽出結果: {}", model);
        return "inst_catalog_list";
    }

    @GetMapping("/inst/reset")
    public String reset(SearchForm searchForm, Model model) {

        model.addAttribute("brands", instrumentService.getBrands());
        searchForm = new SearchForm();
        return "inst_catalog_list";
    }

   
    @GetMapping("/inst/{id}")
    public String initUpdate(@PathVariable("id") Integer id,@ModelAttribute InstFrom instFrom,Model model){
        model.addAttribute("brands", instrumentService.getBrands());
       
        Instrument inst = instrumentService.getInst(id);
        BeanUtils.copyProperties(inst, instFrom);
        return "inst_catalog_update";

    }

}
