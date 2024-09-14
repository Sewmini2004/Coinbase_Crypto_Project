package com.example.Coinbase_Crypto.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CurrencyDTO {
    private Long id;
    private String code;
    private String name;
    private double  price;

}