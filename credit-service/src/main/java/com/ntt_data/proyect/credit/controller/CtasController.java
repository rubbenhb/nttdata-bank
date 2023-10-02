package com.ntt_data.proyect.credit.controller;

import com.ntt_data.proyect.credit.domain.entity.Credit;
import com.ntt_data.proyect.credit.domain.entity.Ctas;
import com.ntt_data.proyect.credit.domain.service.CtasService;
import com.ntt_data.proyect.credit.error.ErrorMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;

@RestController
@RequestMapping(value="/api/v1/ctas")
public class CtasController {
    @Autowired
    private CtasService ctasService;
    @PostMapping
    public ResponseEntity<Credit> createCta(@RequestBody Credit credit, BindingResult result){
        Credit c = ctasService.createCredit(credit.getNroDoc(),credit.getCreditLine(),credit.getDeadline(),credit.getNumQuotas(),credit.getTypeCoin(),credit.getTypeCredit());
        if (c != null) {
            return ResponseEntity.ok(c);
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ErrorMessage.formatMessage(result));
        }
    }
}
