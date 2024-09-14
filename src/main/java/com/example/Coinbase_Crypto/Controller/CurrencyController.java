package com.example.Coinbase_Crypto.Controller;

import com.example.Coinbase_Crypto.Dto.CurrencyDTO;
import com.example.Coinbase_Crypto.Service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/currencies")
public class CurrencyController {

    @Autowired
    private CurrencyService currencyService;

    @GetMapping
    public List<CurrencyDTO> getAllCurrencies() {
        return currencyService.getAllCurrencies().stream().map(currency -> {
            CurrencyDTO dto = new CurrencyDTO();
            dto.setId(currency.getId());
            dto.setCode(currency.getCode());
            dto.setName(currency.getName());
            return dto;
        }).collect(Collectors.toList());
    }
}