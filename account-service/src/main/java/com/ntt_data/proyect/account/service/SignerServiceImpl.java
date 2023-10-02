package com.ntt_data.proyect.account.service;

import com.ntt_data.proyect.account.domain.entity.Signer;
import com.ntt_data.proyect.account.domain.repository.SignerRepository;
import com.ntt_data.proyect.account.domain.service.SignerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class SignerServiceImpl implements SignerService {
    private SignerRepository signerRepository;
    @Override
    public List<Signer> getAll() {
        return signerRepository.findAll();
    }

    @Override
    public Optional<Signer> getById(Long id) {
        return signerRepository.findById(id);
    }

    @Override
    public Signer save(Signer signer) {
        return signerRepository.save(signer);
    }
}
