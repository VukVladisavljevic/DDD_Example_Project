package com.controllers;

import com.DTOs.PurchaseDTO;
import com.DTOs.UserDTO;
import com.domain_services.CustomerDomainService;
import com.domain_services.UserDomainService;
import com.entities.Purchase;
import com.entities.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value= "api")
public class PurchaseController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserDomainService userService;

    @Autowired
    private CustomerDomainService customerDomainService;

    @RequestMapping(value = "/purchase",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Purchase> purchase(@RequestBody PurchaseDTO purchaseDTO) {

        logger.info("> make purchase");

        Purchase retPurchase = customerDomainService.makePurchase(purchaseDTO);

        if (retPurchase == null) {
            System.out.println(" Purchase not created");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        logger.info("< purchase made");
        System.out.println("purchase successfully created");

        return new ResponseEntity<>(retPurchase, HttpStatus.OK);
    }
}
