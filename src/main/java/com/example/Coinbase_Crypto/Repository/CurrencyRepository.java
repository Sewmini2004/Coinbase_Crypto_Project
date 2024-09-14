package com.example.Coinbase_Crypto.Repository;

import com.example.Coinbase_Crypto.Entity.Currency;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyRepository extends JpaRepository<Currency, Long> {
}