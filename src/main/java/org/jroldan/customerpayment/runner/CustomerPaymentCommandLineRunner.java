package org.jroldan.customerpayment.runner;

import org.jroldan.customerpayment.service.matchers.impl.IbanMatcher;
import org.jroldan.customerpayment.service.crud.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

// TODO: Delete
//@Component
public class CustomerPaymentCommandLineRunner implements CommandLineRunner {

    @Autowired
    PaymentService paymentService;

    IbanMatcher ibanMatcher = new IbanMatcher();

    @Override
    public void run(String... args) throws Exception {
        //paymentService.findAll();
        ibanMatcher.match(null, null);
    }
}