package br.com.iagofontes.currencyconverter.core.convert.controller;

import br.com.iagofontes.currencyconverter.core.convert.dto.ConvertResponseDTO;
import br.com.iagofontes.currencyconverter.core.convert.service.ConvertService;
import br.com.iagofontes.currencyconverter.core.symbol.dto.SymbolDTO;
import br.com.iagofontes.currencyconverter.core.symbol.dto.SymbolResponseDTO;
import br.com.iagofontes.currencyconverter.core.symbol.mapper.SymbolResponseMapper;
import br.com.iagofontes.currencyconverter.core.symbol.service.SymbolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/convert")
public class ConvertController {

    @Autowired
    ConvertService convertService;

    @GetMapping
    public ResponseEntity<ConvertResponseDTO> listAvailableSymbols(
            @RequestParam("base") String base,
            @RequestParam("destination") String destination,
            @RequestParam("amount") Double amount
    ) {
        ConvertResponseDTO convertedAmount = this.convertService.convertAmount(base, destination, amount);
        return ResponseEntity.ok(convertedAmount);
    }


}
