package org.jroldan.customerpayment.service.matchers;

import org.jroldan.customerpayment.model.Customer;
import org.jroldan.customerpayment.model.Payment;
import org.jroldan.customerpayment.service.matchers.impl.NameMatcher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
public class NameMatcherTest {

    @Autowired
    public NameMatcher nameMatcher;

    private Customer customer = new Customer();
    private Payment payment = new Payment();

    @Test
    public void matchTrue_whenSameName() {
        customer.setFirstName("Name");
        customer.setLastName("1");
        payment.setName("Name 1");

        assertThat(nameMatcher.match(customer, payment)).isTrue();
    }

    @Test
    public void matchFalse_whenDifferentName() {
        customer.setFirstName("Name");
        customer.setLastName("1");
        payment.setName("Name 2");

        assertThat(nameMatcher.match(customer, payment)).isFalse();
    }
}
