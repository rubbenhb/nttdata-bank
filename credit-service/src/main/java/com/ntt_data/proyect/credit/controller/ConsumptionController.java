package com.ntt_data.proyect.credit.controller;

import com.ntt_data.proyect.credit.domain.entity.Consumption;
import com.ntt_data.proyect.credit.domain.service.ConsumptionService;
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

@RestController
@RequestMapping(value="/api/v1/consumption")
public class ConsumptionController {
    @Autowired
    private ConsumptionService consumptionService;
    @PostMapping
    public ResponseEntity<Consumption> addConsumption(@RequestBody Consumption consumption, BindingResult result){
        Consumption con = consumptionService.create(consumption);
        if(con!=null){
            return ResponseEntity.ok(con);
        }else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ErrorMessage.formatMessage(result));
        }
    }
}
