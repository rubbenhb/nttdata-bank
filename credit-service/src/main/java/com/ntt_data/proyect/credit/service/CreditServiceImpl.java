package com.ntt_data.proyect.credit.service;

import com.ntt_data.proyect.credit.domain.entity.*;
import com.ntt_data.proyect.credit.domain.repository.CreditRepository;
import com.ntt_data.proyect.credit.domain.repository.CtasRepository;
import com.ntt_data.proyect.credit.domain.repository.SignerRepository;
import com.ntt_data.proyect.credit.domain.service.CreditService;
import com.ntt_data.proyect.credit.domain.service.CustomerService;
import com.ntt_data.proyect.credit.domain.service.SignerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor

public class CreditServiceImpl implements CreditService {

    private final SignerRepository signerRepository;
    private  final CustomerService customerService;
    private final SignerService signerService;
    private final CreditRepository creditRepository;
    @Override
    public String paymentByInstallment(Long doc_nro, Date monthQuota) {

        return null;
    }
    @Override
    public List<PaymentSchedule> getAllMovements(Long customerId) {
        return null;
    }

    @Override
    public Credit creditById(Long id) {
        return creditRepository.findById(id).orElse(null);
    }

    @Override
    public List<Credit> findCreditsByNroDoc(Long nroDoc) {
        return null;
    }

    @Override
    public Credit createCreditWithoutCta(Credit credit) {
        Customer cust =customerService.findByNroDoc(credit.getNroDoc());
        if(cust!=null){
            String state="active";
            List<Signer> sig = signerService.findSigners(cust.getId(), state, credit.getTypeCredit());//1,active,personal/tarjeta/empresarial
            if (sig.size()==0){
                Double tea=credit.getTypeCredit()=="credit"? 23.5:60.5;
                Signer sign = Signer.builder()
                        .customer(cust)
                        .cta(null)
                        .relation("titular")
                        .state("active")
                        .product(2)
                        .typeProduct(credit.getTypeCredit()).build();
                signerRepository.save(sign);
                Credit cred = Credit.builder()
                        .deadline(credit.getDeadline())
                        .nroDoc(credit.getNroDoc())
                        .numQuotas(credit.getNumQuotas())
                        .creditLine(credit.getCreditLine())
                        .grantDate(new Date())
                        .tea(tea)  // Ajusta según tus necesidades
                        .typeCoin(credit.getTypeCoin())
                        .typeCredit(credit.getTypeCredit())  // Ajusta según tus necesidades
                        .cta(null)  // Asigna la cuenta recién creada
                        .build();
                return creditRepository.save(cred);
            }

        }

        return null;
    }


}
