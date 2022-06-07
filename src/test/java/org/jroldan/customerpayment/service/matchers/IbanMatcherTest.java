package org.jroldan.customerpayment.service.matchers;

import org.jroldan.customerpayment.model.Customer;
import org.jroldan.customerpayment.model.Payment;
import org.jroldan.customerpayment.service.matchers.impl.IbanMatcher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
public class IbanMatcherTest {

    @Autowired
    public IbanMatcher ibanMatcher;

    private Customer customer = new Customer();
    private Payment payment = new Payment();

    @Test
    public void matchTrue_whenSameIban() {
        customer.setIbanHashed("7859daad1b6947cc05cefc95108c623b");
        payment.setIban("ZZZZQQQQCCCCDDDD");

        assertThat(ibanMatcher.match(customer, payment)).isTrue();
    }

    @Test
    public void matchFalse_whenDifferentAddress() {
        customer.setIbanHashed("7859daad1b6947cc05cefc95108c623b");
        payment.setIban("AAAA2222CCCCZZZZ");

        assertThat(ibanMatcher.match(customer, payment)).isFalse();
    }
}
