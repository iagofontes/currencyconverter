package br.com.iagofontes.currencyconverter.core.symbol.service;

import br.com.iagofontes.currencyconverter.configuration.feign.CurrencyExchangeAPI;
import br.com.iagofontes.currencyconverter.core.symbol.dto.SymbolDTO;
import br.com.iagofontes.currencyconverter.core.symbol.dto.SymbolsExchangeAPIResponseDTO;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class SymbolService {

    @Autowired
    CurrencyExchangeAPI currencyExchangeAPI;

    public List<SymbolDTO> listSymbols() {
        SymbolsExchangeAPIResponseDTO symbols = this.currencyExchangeAPI.listSymbolsFromExchangeAPI();

        List<SymbolDTO> symbolList = new ArrayList<>();
        for (Map.Entry<String, Object> obj : symbols.getSymbols().entrySet().stream().toList()) {
            symbolList.add(SymbolDTO.builder()
                    .code(obj.getKey())
                    .country(obj.getValue().toString())
                    .build());
        }

        return symbolList;
    }

}
