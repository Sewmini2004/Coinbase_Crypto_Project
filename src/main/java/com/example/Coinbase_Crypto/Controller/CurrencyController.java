package com.example.Coinbase_Crypto.Controller;

import com.example.Coinbase_Crypto.Dto.CurrencyDTO;
import com.example.Coinbase_Crypto.Service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
@CrossOrigin("*")
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

    // New POST endpoint to add a currency
    @PostMapping("/add")
    public CurrencyDTO addCurrency(@RequestBody CurrencyDTO currencyDTO) {
        return currencyService.saveCurrency(currencyDTO);
    }


    @GetMapping("/{id}")
    public CurrencyDTO getCurrencyById(@PathVariable Long id) {
        return currencyService.getCurrencyById(id);
    }

    @PutMapping("/update/{id}")
    public CurrencyDTO updateCurrency(@PathVariable Long id, @RequestBody CurrencyDTO currencyDTO) {
        return currencyService.updateCurrency(id, currencyDTO);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCurrency(@PathVariable Long id) {
        currencyService.deleteCurrency(id);
    }





}