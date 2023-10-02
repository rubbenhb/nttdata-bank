package com.ntt_data.proyect.credit.domain.service;

import com.ntt_data.proyect.credit.domain.entity.Credit;
import com.ntt_data.proyect.credit.domain.entity.Ctas;

import java.util.Date;

public interface CtasService {
    public Credit createCredit(Long nroDoc, Double creditLine, Date deadline, int quotas, String typeCoin, String TypeCredit);
}
