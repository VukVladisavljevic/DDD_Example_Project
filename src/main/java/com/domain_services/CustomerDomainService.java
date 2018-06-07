package com.domain_services;

import com.DTOs.PurchaseDTO;
import com.entities.Purchase;
import org.springframework.stereotype.Service;

@Service
public interface CustomerDomainService {

    Purchase makePurchase(PurchaseDTO purchaseDTO);
}
