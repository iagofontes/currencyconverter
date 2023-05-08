package br.com.iagofontes.currencyconverter.core.symbol.dto;

import lombok.Data;

import java.util.Map;

@Data
public class SymbolsExchangeAPIResponseDTO {

    public Boolean success;
    public Map<String, Object> symbols;

}
