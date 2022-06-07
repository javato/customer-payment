package org.jroldan.customerpayment.service.matchers;

import org.jroldan.customerpayment.model.Customer;
import org.jroldan.customerpayment.model.Payment;
import org.jroldan.customerpayment.service.matchers.impl.CommentMatcher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
public class CommentMatcherTest {

    @Autowired
    public CommentMatcher commentMatcher;

    private Customer customer = new Customer();
    private Payment payment = new Payment();

    @Test
    public void matchTrue_whenCommentIsSameThanFirstName() {
        customer.setFirstName("Name");
        customer.setLastName("1");
        customer.setContractId(123456L);
        payment.setComment("Name");

        assertThat(commentMatcher.match(customer, payment)).isTrue();
    }

    @Test
    public void matchTrue_whenCommentIsSameThanLastName() {
        customer.setFirstName("Name");
        customer.setLastName("1");
        customer.setContractId(123456L);
        payment.setComment("1");

        assertThat(commentMatcher.match(customer, payment)).isTrue();
    }

    @Test
    public void matchTrue_whenCommentIsSameThanContractId() {
        customer.setFirstName("Name");
        customer.setLastName("1");
        customer.setContractId(123456L);
        payment.setComment("123456");

        assertThat(commentMatcher.match(customer, payment)).isTrue();
    }

    @Test
    public void matchFalse_whenCommentIsDifferentThanFirstNameAndLastNameAndContractId() {
        customer.setFirstName("Name");
        customer.setLastName("1");
        customer.setContractId(123456L);
        payment.setComment("Useless comment");

        assertThat(commentMatcher.match(customer, payment)).isFalse();
    }
}
