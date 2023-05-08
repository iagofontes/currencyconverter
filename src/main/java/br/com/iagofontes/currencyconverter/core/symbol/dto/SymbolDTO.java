package br.com.iagofontes.currencyconverter.core.symbol.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class SymbolDTO {

    private String code;
    private String country;

}
