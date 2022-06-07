package org.jroldan.customerpayment.service.matchers;

import org.jroldan.customerpayment.model.Customer;
import org.jroldan.customerpayment.model.Payment;
import org.jroldan.customerpayment.service.matchers.impl.AddressMatcher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
public class AddressMatcherTest {

    @Autowired
    public AddressMatcher addressMatcher;

    private Customer customer = new Customer();
    private Payment payment = new Payment();

    @Test
    public void matchTrue_whenSameAddress() {
        customer.setAddress("Address 1");
        payment.setAddress("Address 1");

        assertThat(addressMatcher.match(customer, payment)).isTrue();
    }

    @Test
    public void matchFalse_whenDifferentAddress() {
        customer.setAddress("Address 1");
        payment.setAddress("Address 2");

        assertThat(addressMatcher.match(customer, payment)).isFalse();
    }
}
