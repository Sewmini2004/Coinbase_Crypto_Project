package com.example.Coinbase_Crypto.Repository;

import com.example.Coinbase_Crypto.Entity.ExchangeRate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface ExchangeRateRepository extends JpaRepository<ExchangeRate, Long> {
    List<ExchangeRate> findByCurrencyCodeAndTimestampBetween(String currencyCode, LocalDateTime start, LocalDateTime end);
}