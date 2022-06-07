package org.jroldan.customerpayment.service.matchers.impl;

import org.jroldan.customerpayment.service.matchers.Matcher;
import org.jroldan.customerpayment.model.Customer;
import org.jroldan.customerpayment.model.Payment;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

@Service
public class IbanMatcher implements Matcher {

    @Override
    public boolean match(Customer customer, Payment payment) {
        return DigestUtils.md5DigestAsHex(payment.getIban().getBytes()).toUpperCase()
                .equals(customer.getIbanHashed());
    }
}
