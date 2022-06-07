package org.jroldan.customerpayment.service.matchers.impl;

import org.jroldan.customerpayment.service.matchers.Matcher;
import org.jroldan.customerpayment.model.Customer;
import org.jroldan.customerpayment.model.Payment;
import org.springframework.stereotype.Service;

@Service
public class CommentMatcher implements Matcher {
    @Override
    public boolean match(Customer customer, Payment payment) {
        return findOneMatch(payment.getComment(), customer);
    }

    private boolean findOneMatch(String strToBeCompared, Customer customer) {
        return (strToBeCompared.equals(String.valueOf(customer.getContractId())))
                || (strToBeCompared.equals(customer.getFirstName()))
                || (strToBeCompared.equals(customer.getLastName()));
    }
}