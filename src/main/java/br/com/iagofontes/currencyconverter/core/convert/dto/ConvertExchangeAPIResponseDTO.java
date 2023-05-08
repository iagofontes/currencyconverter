package br.com.iagofontes.currencyconverter.core.convert.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Map;

@Data
@AllArgsConstructor
public class ConvertExchangeAPIResponseDTO {

    public Boolean success;
    public Long timestamp;
    private String base;
    private String date;
    public Map<String, Object> rates;

}
