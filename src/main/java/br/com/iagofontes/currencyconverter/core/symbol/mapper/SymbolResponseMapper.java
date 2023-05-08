package br.com.iagofontes.currencyconverter.core.symbol.mapper;

import br.com.iagofontes.currencyconverter.core.symbol.dto.SymbolDTO;
import br.com.iagofontes.currencyconverter.core.symbol.dto.SymbolResponseDTO;

import java.util.ArrayList;
import java.util.List;

public class SymbolResponseMapper {

    public static List<SymbolResponseDTO> parseFromSymbolDTO(List<SymbolDTO> symbols) {
        List<SymbolResponseDTO> responseSymbols = new ArrayList<>();

        for (SymbolDTO symbol : symbols) {
            responseSymbols.add(
                    SymbolResponseDTO.builder()
                            .symbol(symbol.getCode())
                            .country(symbol.getCountry())
                            .build()
            );
        }

        return responseSymbols;
    }

}
