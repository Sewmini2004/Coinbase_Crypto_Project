package com.example.Coinbase_Crypto.Service;

import com.example.Coinbase_Crypto.Entity.ExchangeRate;
import com.example.Coinbase_Crypto.Repository.ExchangeRateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ExchangeRateService {

    @Autowired
    private ExchangeRateRepository exchangeRateRepository;

    public List<ExchangeRate> getRates(String currencyCode, LocalDateTime start, LocalDateTime end) {
        return exchangeRateRepository.findByCurrencyCodeAndTimestampBetween(currencyCode, start, end);
    }
}