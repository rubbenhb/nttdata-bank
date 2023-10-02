package com.ntt_data.proyect.account.service;

import com.ntt_data.proyect.account.domain.entity.Saving;
import com.ntt_data.proyect.account.domain.entity.Signer;
import com.ntt_data.proyect.account.domain.repository.SavingRepository;
import com.ntt_data.proyect.account.domain.service.SavingService;
import com.ntt_data.proyect.account.domain.service.SignerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class SavingServiceImpl implements SavingService {
    private SavingRepository savingRepository;
    @Override
    public List<Saving> getAll() {
        return savingRepository.findAll();
    }

    @Override
    public Optional<Saving> getById(Long id) {
        return savingRepository.findById(id);
    }

    @Override
    public Saving save(Saving saving) {
        return savingRepository.save(saving);
    }
}
