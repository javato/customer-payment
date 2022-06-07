package org.jroldan.customerpayment.service;

import org.jroldan.customerpayment.model.Customer;
import org.jroldan.customerpayment.model.Payment;
import org.jroldan.customerpayment.service.matchers.Matcher;
import org.jroldan.customerpayment.service.matchers.impl.AddressMatcher;
import org.jroldan.customerpayment.service.matchers.impl.CommentMatcher;
import org.jroldan.customerpayment.service.matchers.impl.IbanMatcher;
import org.jroldan.customerpayment.service.matchers.impl.NameMatcher;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PerfectMatcherService {
    private final List<Matcher> matchers;

    public PerfectMatcherService(List<Matcher> matchers) {
        this.matchers = matchers;
    }

    public boolean gotPerfectMatch(Customer customer, Payment payment) {
        return perfectMatchByIban(customer, payment)
                || perfectMatchByCommentAndName(customer, payment)
                || perfectMatchByCommentAndAddress(customer, payment);
    }

    private boolean perfectMatchByIban(Customer customer, Payment payment) {
        return matchers.stream().filter(matcher -> matcher instanceof IbanMatcher).findFirst().get().match(customer, payment);

    }

    private boolean perfectMatchByCommentAndName(Customer customer, Payment payment) {
        return matchers.stream().filter(matcher -> matcher instanceof CommentMatcher).findFirst().get().match(customer, payment)
                && matchers.stream().filter(matcher -> matcher instanceof NameMatcher).findFirst().get().match(customer, payment);
    }

    private boolean perfectMatchByCommentAndAddress(Customer customer, Payment payment) {
        return matchers.stream().filter(matcher -> matcher instanceof CommentMatcher).findFirst().get().match(customer, payment)
                && matchers.stream().filter(matcher -> matcher instanceof AddressMatcher).findFirst().get().match(customer, payment);
    }
}
