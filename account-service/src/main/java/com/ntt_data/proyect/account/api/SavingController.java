package com.ntt_data.proyect.account.api;

import com.ntt_data.proyect.account.domain.entity.Saving;
import com.ntt_data.proyect.account.domain.service.SavingService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("api/v1/saving")
public class SavingController {
    private final SavingService savingService;

    @GetMapping
    public List<Saving> fetchAll() {return savingService.getAll();}

    @PostMapping
    public ResponseEntity<Saving> create(@RequestBody Saving saving){
        return new ResponseEntity<>(savingService.save(saving), HttpStatus.CREATED);
    }

    @GetMapping("saving/{saving}")
    public Optional<Saving> fetchById(@PathVariable Long saving){return savingService.getById(saving);}
}
