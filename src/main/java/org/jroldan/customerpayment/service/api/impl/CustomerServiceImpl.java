package org.jroldan.customerpayment.service.api.impl;

import org.jroldan.customerpayment.dao.repository.CustomerRepository;
import org.jroldan.customerpayment.exception.CustomerPaymentException;
import org.jroldan.customerpayment.model.Customer;
import org.jroldan.customerpayment.service.api.CustomerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer findById(Long aLong) throws CustomerPaymentException {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<Customer> findAll() throws CustomerPaymentException {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean exists(Customer entity) throws CustomerPaymentException {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean existsById(Long aLong) throws CustomerPaymentException {
        throw new UnsupportedOperationException();
    }

    @Override
    public Customer saveOrUpdate(Customer entity) throws CustomerPaymentException {
        throw new UnsupportedOperationException();
    }

    @Override
    public void validate(Customer entity) throws CustomerPaymentException {
        throw new UnsupportedOperationException();
    }

    @Override
    public void delete(Customer entity) throws CustomerPaymentException {
        throw new UnsupportedOperationException();
    }

    @Override
    public void deleteById(Long aLong) throws CustomerPaymentException {
        throw new UnsupportedOperationException();
    }
}
