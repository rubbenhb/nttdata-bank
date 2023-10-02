package com.ntt_data.proyect.account.domain.service;

import com.ntt_data.proyect.account.domain.entity.Cta;

import java.util.List;

public interface CtaService {
    List<Cta> getAll();
    List<Cta> getById(Long id);
    Cta save(Cta cta);
}
