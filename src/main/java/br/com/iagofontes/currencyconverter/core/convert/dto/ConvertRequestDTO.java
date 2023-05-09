package br.com.iagofontes.currencyconverter.core.convert.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class ConvertRequestDTO {

    @NotBlank(message = "The base currency is required")
    @JsonProperty("base_currency")
    public String baseCurrency;

    @NotBlank(message = "The destination currency is required")
    @JsonProperty("destination_currency")
    public String destinationCurrency;

    @NotNull(message = "The destination currency is required")
    @Positive(message = "The amount must be greater then 0")
    @JsonProperty("amount")
    public Double amount;

}
