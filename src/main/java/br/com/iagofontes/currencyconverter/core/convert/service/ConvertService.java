package br.com.iagofontes.currencyconverter.core.convert.service;

import br.com.iagofontes.currencyconverter.configuration.feign.CurrencyExchangeAPI;
import br.com.iagofontes.currencyconverter.core.convert.dto.ConvertExchangeAPIResponseDTO;
import br.com.iagofontes.currencyconverter.core.convert.dto.ConvertResponseDTO;
import br.com.iagofontes.currencyconverter.core.symbol.dto.SymbolDTO;
import br.com.iagofontes.currencyconverter.core.symbol.dto.SymbolsExchangeAPIResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ConvertService {

    @Autowired
    CurrencyExchangeAPI currencyExchangeAPI;

    public ConvertResponseDTO convertAmount(String baseCurrency, String destinationCurrency, Double amount) {

        ConvertExchangeAPIResponseDTO exchangeRate = this.currencyExchangeAPI.getRateFromExchangeAPI(baseCurrency);

        Optional<Map.Entry<String, Object>> rate = exchangeRate.getRates()
                .entrySet()
                .stream()
                .filter(item -> destinationCurrency.equalsIgnoreCase(item.getKey()))
                .findFirst();

        return ConvertResponseDTO.builder()
                .baseCurrency(baseCurrency)
                .destinationCurrency(destinationCurrency)
                .amount(this.calculateExchangeValue(Double.valueOf(rate.get().getValue().toString()), amount))
                .build();

    }

    private Double calculateExchangeValue(Double rate, Double amount) {
        return amount * rate;
    }

}
