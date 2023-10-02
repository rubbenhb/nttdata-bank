package com.ntt_data.proyect.account.api;

import com.ntt_data.proyect.account.domain.entity.Cta;
import com.ntt_data.proyect.account.domain.service.CtaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("api/v1/cta")
public class CtaController {
    private final CtaService ctaService;

    @GetMapping
    public List<Cta> fetchAll() {return ctaService.getAll();}

    @PostMapping
    public ResponseEntity<Cta> create(@RequestBody Cta cta){
        return new ResponseEntity<>(ctaService.save(cta), HttpStatus.CREATED);
    }

    @GetMapping("cta/{cta}")
    public List<Cta> fetchByCta(@PathVariable Long cta){
        return ctaService.getById(cta);
    }
}
