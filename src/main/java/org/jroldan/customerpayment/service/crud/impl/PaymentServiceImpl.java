package org.jroldan.customerpayment.service.crud.impl;

import org.jroldan.customerpayment.dao.repository.PaymentRepository;
import org.jroldan.customerpayment.exception.CustomerPaymentException;
import org.jroldan.customerpayment.model.Payment;
import org.jroldan.customerpayment.service.crud.PaymentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;

    public PaymentServiceImpl(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Override
    public Payment findById(Long id) throws CustomerPaymentException {
        return paymentRepository.findById(id).get();
    }

    @Override
    public List<Payment> findAll() throws CustomerPaymentException {
        return StreamSupport.stream(paymentRepository.findAll().spliterator(), false).collect(Collectors.toList());
    }

    @Override
    public boolean exists(Payment entity) throws CustomerPaymentException {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean existsById(Long aLong) throws CustomerPaymentException {
        throw new UnsupportedOperationException();
    }

    @Override
    public Payment saveOrUpdate(Payment entity) throws CustomerPaymentException {
        throw new UnsupportedOperationException();
    }

    @Override
    public void validate(Payment entity) throws CustomerPaymentException {
        throw new UnsupportedOperationException();
    }

    @Override
    public void delete(Payment entity) throws CustomerPaymentException {
        throw new UnsupportedOperationException();
    }

    @Override
    public void deleteById(Long aLong) throws CustomerPaymentException {
        throw new UnsupportedOperationException();
    }
}
