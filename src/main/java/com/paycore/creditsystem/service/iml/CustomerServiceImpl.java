package com.paycore.creditsystem.service.iml;

import com.paycore.creditsystem.exception.IdentityNumberAlreadyExistException;
import com.paycore.creditsystem.exception.NotFoundException;
import com.paycore.creditsystem.model.CreditScore;
import com.paycore.creditsystem.model.Customer;
import com.paycore.creditsystem.model.dto.CustomerDto;
import com.paycore.creditsystem.model.mapper.CustomerMapper;
import com.paycore.creditsystem.repository.CustomerRepository;
import com.paycore.creditsystem.service.CreditScoreService;
import com.paycore.creditsystem.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final CreditScoreService creditScoreService;

    @Override
    public Customer getCustomer(Integer id) {
        Optional<Customer> byId= customerRepository.findById(id);
        return byId.orElseThrow(()->new NotFoundException("Customer"));
    }

    @Override
    public Customer addCustomer(CustomerDto customerDto) {
        Customer customer=CustomerMapper.toEntity(customerDto);

        CreditScore creditScore= creditScoreService.calculateCreditScore();

        customer.setCreditScore(creditScore);
        if(customerRepository.findByIdentityNumber(customer.getIdentityNumber())!=null){
          throw  new IdentityNumberAlreadyExistException();
        }
       return customerRepository.save(customer);
    }

    @Override
    public boolean deleteCustomer(Integer id) {
        customerRepository.delete(getCustomer(id));
        return true;
    }

    @Override
    public Customer updateCustomer(Integer id, Customer customer) {
        getCustomer(id);
        customer.setId(id);
        customerRepository.save(customer);
        return customer;
    }

    @Override
    public Customer getCustomerByIdentityNumber(String identityNumber) {
        Customer customer=customerRepository.findByIdentityNumber(identityNumber);
        if (customer==null){
           throw new NotFoundException("Customer that has this identity number  ");
        }
        return customer;
    }
}
