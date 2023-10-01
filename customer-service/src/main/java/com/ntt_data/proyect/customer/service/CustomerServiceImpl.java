package com.ntt_data.proyect.customer.service;

import com.ntt_data.proyect.customer.domain.entity.Customer;
import com.ntt_data.proyect.customer.domain.entity.CustomerType;
import com.ntt_data.proyect.customer.domain.repository.CustomerRepository;
import com.ntt_data.proyect.customer.domain.repository.CustomerTypeRepository;
import com.ntt_data.proyect.customer.domain.service.ICustomerService;
import com.ntt_data.proyect.customer.service.dto.RequestCustomerDto;
import com.ntt_data.proyect.customer.service.dto.ResponseCustomerDto;
import com.ntt_data.proyect.customer.service.exceptions.ExistsDocumentNumberException;
import com.ntt_data.proyect.customer.service.exceptions.MalformedDocumentNumberException;
import com.ntt_data.proyect.customer.service.exceptions.NotFoundCustomerTypeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements ICustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerTypeRepository customerTypeRepository;

    @Override
    public ResponseCustomerDto save(RequestCustomerDto requestCustomerDto) {
        CustomerType customerType = customerTypeRepository.findById(requestCustomerDto.getCustomerType()).orElseThrow(() -> new NotFoundCustomerTypeException("Customer Type not found"));

        String documentNumber = String.valueOf(requestCustomerDto.getDocumentNumber());

        if (customerType.getId() == 1 && !documentNumber.matches("\\d{8}")) {
            throw new MalformedDocumentNumberException("The document number must be 8 digits");
        }

        if (customerType.getId() == 2 && !documentNumber.matches("^20\\d{9}")) {
            throw new MalformedDocumentNumberException("The document number must be 11 digits long and start with 20");
        }

        if(customerRepository.existsByDocumentNumber(requestCustomerDto.getDocumentNumber())) {
            throw new ExistsDocumentNumberException("Document number already exists");
        }

        Customer newCustomer = new Customer();
        newCustomer.setFirstName(requestCustomerDto.getFirstName());
        newCustomer.setLastName(requestCustomerDto.getLastName());
        newCustomer.setDocumentType(customerType.getId() == 1 ?1 :2);
        newCustomer.setDocumentNumber(requestCustomerDto.getDocumentNumber());
        newCustomer.setGender(requestCustomerDto.getGender());
        newCustomer.setState(1);
        newCustomer.setCustomerType(customerType);

        customerRepository.save(newCustomer);

        return customerToCustomerDto(newCustomer);
    }

    @Override
    public List<ResponseCustomerDto> findAll(String lastName, Long documentNumber) {
        return customerRepository
                .findCustomers(lastName, documentNumber)
                .stream()
                .map(this::customerToCustomerDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<ResponseCustomerDto> findByCustomerType(Long customerTypeId) {
        CustomerType customerType = customerTypeRepository.findById(customerTypeId).orElseThrow(() -> new NotFoundCustomerTypeException("Customer type not found"));
        return customerType.getCustomers()
                .stream()
                .map(this::customerToCustomerDto)
                .collect(Collectors.toList());
    }

    private ResponseCustomerDto customerToCustomerDto(Customer customer) {
        return new ResponseCustomerDto(
                customer.getId(),
                customer.getFirstName(),
                customer.getLastName(),
                customer.getDocumentType() == 1 ?"Dni" :"Ruc",
                customer.getDocumentNumber(),
                customer.getGender() == 1 ?"Male" :"Female",
                customer.getState() == 1 ?"Active" :"Disabled",
                customer.getCustomerType().getId() == 1 ?"Personal" :"Business"
        );
    }
}