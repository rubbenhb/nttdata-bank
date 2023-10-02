package com.ntt_data.proyect.account.domain.service;

import com.ntt_data.proyect.account.domain.entity.Saving;

import java.util.List;
import java.util.Optional;

public interface SavingService {
    List<Saving> getAll();
    Optional<Saving> getById(Long id);
    Saving save(Saving saving);
}
