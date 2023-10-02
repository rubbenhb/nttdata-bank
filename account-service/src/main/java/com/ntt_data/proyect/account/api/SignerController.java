package com.ntt_data.proyect.account.api;

import com.ntt_data.proyect.account.domain.entity.Signer;
import com.ntt_data.proyect.account.domain.service.SignerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("api/v1/signer")
public class SignerController {
    private final SignerService signerService;

    @GetMapping
    public List<Signer> fetchAll() {return signerService.getAll();}

    @PostMapping
    public ResponseEntity<Signer> create(@RequestBody Signer signer){
        return new ResponseEntity<>(signerService.save(signer), HttpStatus.CREATED);
    }

    @GetMapping("signer/{signer}")
    public Optional<Signer> fetchById(@PathVariable Long signer){return signerService.getById(signer);}
}
