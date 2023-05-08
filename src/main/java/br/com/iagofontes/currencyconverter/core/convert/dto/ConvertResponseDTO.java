package br.com.iagofontes.currencyconverter.core.convert.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ConvertResponseDTO {

    @JsonProperty("base_currency")
    public String baseCurrency;

    @JsonProperty("destination_currency")
    public String destinationCurrency;

    @JsonProperty("amount")
    public Double amount;

}
