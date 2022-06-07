package org.jroldan.customerpayment.service;

import org.jroldan.customerpayment.service.matchers.Matcher;
import org.jroldan.customerpayment.model.Customer;
import org.jroldan.customerpayment.model.Payment;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class PerfectMatcherService {
    private final Map<String, Matcher> matchers;

    public PerfectMatcherService(Map<String, Matcher> matchers) {
        this.matchers = matchers;
    }

    public boolean gotPerfectMatch(Customer customer, Payment payment) {
        return perfectMatchByIban(customer, payment)
                || perfectMatchByCommentAndName(customer, payment)
                || perfectMatchByCommentAndAddress(customer, payment);
    }

    // iban match
    private boolean perfectMatchByIban(Customer customer, Payment payment) {
        return matchers.get("ibanMatcher").match(customer, payment);
    }

    // Comment match + name match
    private boolean perfectMatchByCommentAndName(Customer customer, Payment payment) {
        return matchers.get("commentMatcher").match(customer, payment) && matchers.get("nameMatcher").match(customer, payment);
    }

    // comment match + address match
    private boolean perfectMatchByCommentAndAddress(Customer customer, Payment payment) {
        return matchers.get("commentMatcher").match(customer, payment) && matchers.get("addressMatcher").match(customer, payment);
    }
}
