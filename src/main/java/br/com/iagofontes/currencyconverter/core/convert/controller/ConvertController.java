package br.com.iagofontes.currencyconverter.core.convert.controller;

import br.com.iagofontes.currencyconverter.core.convert.dto.ConvertRequestDTO;
import br.com.iagofontes.currencyconverter.core.convert.dto.ConvertResponseDTO;
import br.com.iagofontes.currencyconverter.core.convert.service.ConvertService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/convert")
public class ConvertController {

    @Autowired
    ConvertService convertService;

    @PostMapping
    public ResponseEntity<ConvertResponseDTO> convertAmount(
            @RequestBody @Valid ConvertRequestDTO body
    ) {
        ConvertResponseDTO convertedAmount = this.convertService.convertAmount(body.baseCurrency, body.destinationCurrency, body.amount);
        return ResponseEntity.ok(convertedAmount);
    }


}
