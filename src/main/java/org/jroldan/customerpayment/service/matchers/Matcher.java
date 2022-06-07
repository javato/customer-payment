package org.jroldan.customerpayment.service.matchers;

import org.jroldan.customerpayment.model.Customer;
import org.jroldan.customerpayment.model.Payment;

public interface Matcher {
    public boolean match(Customer customer, Payment payment);
}
