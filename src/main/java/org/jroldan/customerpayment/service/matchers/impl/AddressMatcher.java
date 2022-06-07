package org.jroldan.customerpayment.service.matchers.impl;

import org.jroldan.customerpayment.service.matchers.Matcher;
import org.jroldan.customerpayment.model.Customer;
import org.jroldan.customerpayment.model.Payment;
import org.springframework.stereotype.Service;

@Service
public class AddressMatcher implements Matcher {
    @Override
    public boolean match(Customer customer, Payment payment) {
        return customer.getAddress().equals(payment.getAddress());
    }
}
