package com.ntt_data.proyect.credit.service;

import com.ntt_data.proyect.credit.domain.entity.Signer;
import com.ntt_data.proyect.credit.domain.repository.SignerRepository;
import com.ntt_data.proyect.credit.domain.service.SignerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class SignerServiceImpl implements SignerService {
    private final SignerRepository signerRepository;

    @Override
    public List<Signer> findSigners(Long customerId, String state, String typeProduct) {
        return signerRepository.findByCustomer_IdAndStateAndTypeProduct(customerId, state, typeProduct);
    }
}
