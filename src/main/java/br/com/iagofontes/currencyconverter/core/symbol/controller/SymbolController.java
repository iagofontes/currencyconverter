package br.com.iagofontes.currencyconverter.core.symbol.controller;

import br.com.iagofontes.currencyconverter.core.symbol.dto.SymbolDTO;
import br.com.iagofontes.currencyconverter.core.symbol.dto.SymbolResponseDTO;
import br.com.iagofontes.currencyconverter.core.symbol.mapper.SymbolResponseMapper;
import br.com.iagofontes.currencyconverter.core.symbol.service.SymbolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/symbols")
public class SymbolController {

    @Autowired
    SymbolService symbolService;

    @GetMapping
    public ResponseEntity<List<SymbolResponseDTO>> listAvailableSymbols() {
        List<SymbolDTO> symbols = this.symbolService.listSymbols();
        return ResponseEntity.ok(SymbolResponseMapper.parseFromSymbolDTO(symbols));
    }

}
