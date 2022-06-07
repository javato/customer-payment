package org.jroldan.customerpayment.service;

import org.jroldan.customerpayment.model.Customer;
import org.jroldan.customerpayment.model.Payment;
import org.jroldan.customerpayment.service.matchers.impl.AddressMatcher;
import org.jroldan.customerpayment.service.matchers.impl.CommentMatcher;
import org.jroldan.customerpayment.service.matchers.impl.IbanMatcher;
import org.jroldan.customerpayment.service.matchers.impl.NameMatcher;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
public class PerfectMatcherServiceTest {
    @Autowired
    public PerfectMatcherService perfectMatcherService;

    @MockBean
    public AddressMatcher addressMatcher;

    @MockBean
    public CommentMatcher commentMatcher;

    @MockBean
    public IbanMatcher ibanMatcher;

    @MockBean
    public NameMatcher nameMatcher;

    private Customer customer = new Customer();
    private Payment payment = new Payment();

    @Test
    public void perfectMatchTrue_whenOnlyIbanMatch() {
        Mockito.doReturn(false).when(addressMatcher).match(Mockito.any(), Mockito.any());
        Mockito.doReturn(false).when(commentMatcher).match(Mockito.any(), Mockito.any());
        Mockito.doReturn(true).when(ibanMatcher).match(Mockito.any(), Mockito.any());
        Mockito.doReturn(false).when(nameMatcher).match(Mockito.any(), Mockito.any());

        assertThat(perfectMatcherService.gotPerfectMatch(customer, payment)).isTrue();
    }

    @Test
    public void perfectMatchTrue_whenCommentAndNameMatch() {
        Mockito.doReturn(false).when(addressMatcher).match(Mockito.any(), Mockito.any());
        Mockito.doReturn(true).when(commentMatcher).match(Mockito.any(), Mockito.any());
        Mockito.doReturn(false).when(ibanMatcher).match(Mockito.any(), Mockito.any());
        Mockito.doReturn(true).when(nameMatcher).match(Mockito.any(), Mockito.any());

        assertThat(perfectMatcherService.gotPerfectMatch(customer, payment)).isTrue();
    }

    @Test
    public void perfectMatchTrue_whenCommentAndAddressMatch() {
        Mockito.doReturn(true).when(addressMatcher).match(Mockito.any(), Mockito.any());
        Mockito.doReturn(true).when(commentMatcher).match(Mockito.any(), Mockito.any());
        Mockito.doReturn(false).when(ibanMatcher).match(Mockito.any(), Mockito.any());
        Mockito.doReturn(false).when(nameMatcher).match(Mockito.any(), Mockito.any());

        assertThat(perfectMatcherService.gotPerfectMatch(customer, payment)).isTrue();
    }

    @Test
    public void perfectMatchFalse_whenNoMatch() {
        Mockito.doReturn(false).when(addressMatcher).match(Mockito.any(), Mockito.any());
        Mockito.doReturn(false).when(commentMatcher).match(Mockito.any(), Mockito.any());
        Mockito.doReturn(false).when(ibanMatcher).match(Mockito.any(), Mockito.any());
        Mockito.doReturn(false).when(nameMatcher).match(Mockito.any(), Mockito.any());

        assertThat(perfectMatcherService.gotPerfectMatch(customer, payment)).isFalse();
    }
}
