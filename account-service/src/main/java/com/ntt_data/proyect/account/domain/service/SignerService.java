package com.ntt_data.proyect.account.domain.service;

import com.ntt_data.proyect.account.domain.entity.Signer;

import java.util.List;
import java.util.Optional;

public interface SignerService {
    List<Signer> getAll();
    Optional<Signer> getById(Long id);
    Signer save(Signer signer);
}
