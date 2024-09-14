package com.example.Coinbase_Crypto.Controller;

import com.example.Coinbase_Crypto.Entity.ExchangeRate;
import com.example.Coinbase_Crypto.Service.ExchangeRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ExchangeRateController {
    @Autowired
    private ExchangeRateService exchangeRateService;

    @GetMapping("/rates")
    public ResponseEntity<Object> getRates(
            @RequestParam String currencyCode,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime start,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime end) {
        List<ExchangeRate> rates = exchangeRateService.getRates(currencyCode, start, end);
        return ResponseEntity.ok(rates);
    }
}
