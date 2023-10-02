package com.ntt_data.proyect.credit.domain.service;

import com.ntt_data.proyect.credit.domain.entity.Signer;

import java.util.List;

public interface SignerService {
    public List<Signer> findSigners(Long customerId,String state, String typeProduct);
}
