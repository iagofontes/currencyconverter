package br.com.iagofontes.currencyconverter.core.symbol.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class SymbolResponseDTO {

    @JsonProperty("symbol")
    private String symbol;

    @JsonProperty("country")
    private String country;

}
