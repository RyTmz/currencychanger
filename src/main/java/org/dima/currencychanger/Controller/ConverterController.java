package org.dima.currencychanger.Controller;

import org.dima.currencychanger.Entity.Currency;
import org.dima.currencychanger.Util.XMLParcer;
import org.dima.currencychanger.form.ConverterForm;
import org.dima.currencychanger.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ConverterController {
    private final CurrencyService currencyService;

    @Autowired
    public ConverterController(CurrencyService currencyService){
        this.currencyService = currencyService;
    }

    @PostMapping("/converter")
    public String postData(@RequestBody ConverterForm convertForm){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("converter");
        double convertResult = convertForm.getQuantity();
        mv.addObject("result",convertResult);
        return "converter";
    }

    @GetMapping("/converter")
    public ModelAndView getData() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("convertertest");
        currencyService.addAllCurencies();
        Iterable <Currency> currencies = currencyService.getCurrencyList();
        mv.addObject("currencies", currencies);
        return mv;
    }
}
