package com.example.Coinbase_Crypto.Service;

import com.example.Coinbase_Crypto.Dto.CurrencyDTO;
import com.example.Coinbase_Crypto.Entity.Currency;
import com.example.Coinbase_Crypto.Repository.CurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CurrencyService {

    @Autowired
    private CurrencyRepository currencyRepository;

    public List<CurrencyDTO> getAllCurrencies() {
        return currencyRepository.findAll().stream().map(currency -> {
            CurrencyDTO dto = new CurrencyDTO();
            dto.setId(currency.getId());
            dto.setCode(currency.getCode());
            dto.setName(currency.getName());
            dto.setPrice(currency.getPrice());
            return dto;
        }).collect(Collectors.toList());
    }

    public CurrencyDTO updatePrice(String fromCode, String toCode, Double amount) {
        Currency fromCurrency = currencyRepository.findByCode(fromCode);
        Currency toCurrency = currencyRepository.findByCode(toCode);

        double convertedAmount = (amount / fromCurrency.getPrice()) * toCurrency.getPrice();

        CurrencyDTO dto = new CurrencyDTO();
        dto.setCode(toCurrency.getCode());
        dto.setName(toCurrency.getName());
        dto.setPrice(convertedAmount);

        return dto;
    }


    // New method to save a currency
    public CurrencyDTO saveCurrency(CurrencyDTO currencyDTO) {
        Currency currency = new Currency();
        currency.setCode(currencyDTO.getCode());
        currency.setName(currencyDTO.getName());
        currency.setPrice(currencyDTO.getPrice());

        Currency savedCurrency = currencyRepository.save(currency);

        currencyDTO.setId(savedCurrency.getId());
        return currencyDTO;
    }


    public CurrencyDTO getCurrencyById(Long id) {
        Currency currency = currencyRepository.findById(id).orElseThrow(() -> new RuntimeException("Currency not found"));
        CurrencyDTO dto = new CurrencyDTO();
        dto.setId(currency.getId());
        dto.setCode(currency.getCode());
        dto.setName(currency.getName());
        dto.setPrice(currency.getPrice());
        return dto;
    }

    public CurrencyDTO updateCurrency(Long id, CurrencyDTO currencyDTO) {
        Currency currency = currencyRepository.findById(id).orElseThrow(() -> new RuntimeException("Currency not found"));
        currency.setCode(currencyDTO.getCode());
        currency.setName(currencyDTO.getName());
        currency.setPrice(currencyDTO.getPrice());
        Currency updatedCurrency = currencyRepository.save(currency);
        currencyDTO.setId(updatedCurrency.getId());
        return currencyDTO;
    }

    public void deleteCurrency(Long id) {
        currencyRepository.deleteById(id);
    }



}
