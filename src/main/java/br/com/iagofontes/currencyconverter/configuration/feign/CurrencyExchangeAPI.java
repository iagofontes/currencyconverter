package br.com.iagofontes.currencyconverter.configuration.feign;

import br.com.iagofontes.currencyconverter.core.convert.dto.ConvertExchangeAPIResponseDTO;
import br.com.iagofontes.currencyconverter.core.symbol.dto.SymbolsExchangeAPIResponseDTO;
import feign.Param;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(url = "${spring.feign.exchangeapi.url}", name = "${spring.feign.exchangeapi.name}")
public interface CurrencyExchangeAPI {

    @GetMapping(value = "${spring.feign.exchangeapi.path.symbols}", produces = "application/json")
    SymbolsExchangeAPIResponseDTO listSymbolsFromExchangeAPI();

    @GetMapping(value = "${spring.feign.exchangeapi.path.rate}?base=${base}", produces = "application/json")
    ConvertExchangeAPIResponseDTO getRateFromExchangeAPI(@RequestParam("base") String base);

}
