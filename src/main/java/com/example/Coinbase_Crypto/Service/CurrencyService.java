package com.example.Coinbase_Crypto.Service;

import com.example.Coinbase_Crypto.Entity.Currency;
import com.example.Coinbase_Crypto.Repository.CurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CurrencyService {

    @Autowired
    private CurrencyRepository currencyRepository;

    public List<Currency> getAllCurrencies() {
        return currencyRepository.findAll();
    }
}