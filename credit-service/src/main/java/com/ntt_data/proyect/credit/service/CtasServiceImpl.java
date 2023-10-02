package com.ntt_data.proyect.credit.service;

import com.ntt_data.proyect.credit.domain.entity.Credit;
import com.ntt_data.proyect.credit.domain.entity.Ctas;
import com.ntt_data.proyect.credit.domain.entity.Customer;
import com.ntt_data.proyect.credit.domain.entity.Signer;
import com.ntt_data.proyect.credit.domain.repository.CreditRepository;
import com.ntt_data.proyect.credit.domain.repository.CtasRepository;
import com.ntt_data.proyect.credit.domain.repository.SignerRepository;
import com.ntt_data.proyect.credit.domain.service.CreditService;
import com.ntt_data.proyect.credit.domain.service.CtasService;
import com.ntt_data.proyect.credit.domain.service.CustomerService;
import com.ntt_data.proyect.credit.domain.service.SignerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;
@Service
@RequiredArgsConstructor
public class CtasServiceImpl implements CtasService {
    private final CustomerService customerService;
    private final SignerService signerService;
    private final CtasRepository ctasRepository;
    private final CreditRepository creditRepository;
    private final SignerRepository signerRepository;

    @Override
    public Credit createCredit(Long nroDoc, Double creditLine, Date deadline, int quotas, String typeCoin, String typeCredit) {
        System.out.println("entro aca");
        Double tea=typeCredit=="credit"? 23.5:60.5;
        Customer cust =customerService.findByNroDoc(nroDoc);
        String state = "active";
        if(cust !=null){
            List<Signer> sig = signerService.findSigners(cust.getId(), state, typeCredit);//1,active,personal/tarjeta/empresarial
            if(sig.size()==0){
                Ctas cuenta = Ctas.builder()
                        .typeProduct(typeCredit)
                        .dateCreation(new Date())
                        .dateClose(null)
                        .state("active").build();
                Ctas cta = ctasRepository.save(cuenta);
                Signer sign = Signer.builder()
                        .customer(cust)
                        .cta(cuenta)
                        .relation("titular")
                        .state("active")
                        .product(2)
                        .typeProduct(typeCredit).build();
                signerRepository.save(sign);
                Credit credit = Credit.builder()
                        .deadline(deadline)
                        .nroDoc(nroDoc)
                        .numQuotas(quotas)
                        .creditLine(creditLine)
                        .grantDate(new Date())
                        .tea(tea)  // Ajusta según tus necesidades
                        .typeCoin(typeCoin)
                        .typeCredit(typeCredit)  // Ajusta según tus necesidades
                        .cta(cta)  // Asigna la cuenta recién creada
                        .build();
                return creditRepository.save(credit);
            }else{
                return null;
            }
        }else {
            return null;
        }
    }

}
