package com.example.Coinbase_Crypto.Repository;

import com.example.Coinbase_Crypto.Entity.Currency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrencyRepository extends JpaRepository<Currency, Long> {
    Currency findByCode(String code);
}