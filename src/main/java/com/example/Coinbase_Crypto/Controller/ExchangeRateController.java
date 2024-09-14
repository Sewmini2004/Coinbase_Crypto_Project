package com.example.Coinbase_Crypto.Controller;

import com.example.Coinbase_Crypto.Dto.ExchangeRateDTO;
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
import java.util.stream.Collectors;


@RestController
@RequestMapping("/api/rates")
public class ExchangeRateController {

    @Autowired
    private ExchangeRateService exchangeRateService;

    @GetMapping
    public ResponseEntity<List<ExchangeRateDTO>> getRates(
            @RequestParam String currencyCode,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime start,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime end) {

        List<ExchangeRate> rates = exchangeRateService.getRates(currencyCode, start, end);

        List<ExchangeRateDTO> response = rates.stream().map(rate -> {
            ExchangeRateDTO dto = new ExchangeRateDTO();
            dto.setId(rate.getId());
            dto.setCurrencyCode(rate.getCurrencyCode());
            dto.setRate(rate.getRate());
            dto.setTimestamp(rate.getTimestamp());
            return dto;
        }).collect(Collectors.toList());

        return ResponseEntity.ok(response);
    }
}
