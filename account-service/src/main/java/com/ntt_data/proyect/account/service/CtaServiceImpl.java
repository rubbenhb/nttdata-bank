package com.ntt_data.proyect.account.service;

import com.ntt_data.proyect.account.domain.entity.Cta;
import com.ntt_data.proyect.account.domain.repository.CtaRepository;
import com.ntt_data.proyect.account.domain.service.CtaService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class CtaServiceImpl implements CtaService {
    private CtaRepository ctaRepository;
    @Override
    public List<Cta> getAll() {
        return ctaRepository.findAll();
    }

    @Override
    public List<Cta> getById(Long cta) {
        return ctaRepository.findByCta(cta);
    }

    @Override
    public Cta save(Cta cta) {
        return ctaRepository.save(cta);
    }
}
