package org.BartoszM.currencyConverter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyController {
    private final CurrencyService currencyService;

    public CurrencyController(CurrencyService currencyService) {
        this.currencyService = currencyService;
    }

    @GetMapping("/api/convert")
    public ConversionResponse convertCurrency(@RequestParam("code") String code, @RequestParam("amount") double amount){
        return currencyService.convert(code,amount);
    }
}
