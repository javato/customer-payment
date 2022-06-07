package org.jroldan.customerpayment.controller;

import org.jroldan.customerpayment.service.PerfectMatcherService;
import org.jroldan.customerpayment.service.crud.CustomerService;
import org.jroldan.customerpayment.service.crud.PaymentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("perfect-match-api")
public class PerfectMatcherController {

    private final PerfectMatcherService perfectMatcherService;

    private final CustomerService customerService;

    private final PaymentService paymentService;

    public PerfectMatcherController(PerfectMatcherService perfectMatcherService, CustomerService customerService, PaymentService paymentService) {
        this.perfectMatcherService = perfectMatcherService;
        this.customerService = customerService;
        this.paymentService = paymentService;
    }

    @GetMapping
    public ResponseEntity<Boolean> perfectMatchChecker(@RequestParam(value = "customerId", required = true) Long customerId, @RequestParam(value = "paymentId", required = true) Long paymentId) {
        try {
            return new ResponseEntity<>(
                    perfectMatcherService.gotPerfectMatch(
                            customerService.findById(customerId),
                            paymentService.findById(paymentId)),
                    HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<Boolean>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
