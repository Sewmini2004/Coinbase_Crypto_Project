package com.example.Coinbase_Crypto.Controller;

import com.example.Coinbase_Crypto.Dto.CurrencyDTO;
import com.example.Coinbase_Crypto.Service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
@CrossOrigin
@RestController
@RequestMapping("/api/currencies")
public class CurrencyController {

    @Autowired
    private CurrencyService currencyService;

    @GetMapping("/all")
    public List<CurrencyDTO> getAllCurrencies() {
        return currencyService.getAllCurrencies();
    }

    @GetMapping("/convert")
    public CurrencyDTO convertCurrency(
            @RequestParam String fromCode,
            @RequestParam String toCode,
            @RequestParam Double amount
    ) {
        return currencyService.updatePrice(fromCode, toCode, amount);
    }



}