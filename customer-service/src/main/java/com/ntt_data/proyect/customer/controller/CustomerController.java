package com.ntt_data.proyect.customer.controller;

import com.ntt_data.proyect.customer.domain.service.ICustomerService;
import com.ntt_data.proyect.customer.service.dto.RequestCustomerDto;
import com.ntt_data.proyect.customer.service.dto.ResponseCustomerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;

    @PostMapping("")
    public ResponseEntity<ResponseCustomerDto> save(@Valid @RequestBody RequestCustomerDto requestCustomerDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(customerService.save(requestCustomerDto));
    }

    @GetMapping("")
    public ResponseEntity<List<ResponseCustomerDto>> findAll(
            @RequestParam(required = false) String lastName,
            @RequestParam(required = false) Long documentNumber) {
        return ResponseEntity.status(HttpStatus.OK).body(customerService.findAll(lastName, documentNumber));
    }

    @GetMapping("/type/{customerTypeId}")
    public ResponseEntity<List<ResponseCustomerDto>> findByCustomerType(@PathVariable Long customerTypeId) {
        return ResponseEntity.status(HttpStatus.OK).body(customerService.findByCustomerType(customerTypeId));
    }
}