package com.domain_services;

import com.DTOs.PurchaseDTO;
import com.entities.Customer;
import com.entities.Purchase;
import com.entities.PurchasedArticle;
import com.entities.User;
import com.repositories.ArticleRepository;
import com.repositories.PurchaseRepository;
import com.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CustomerDomainServiceImpl implements CustomerDomainService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private PurchaseRepository purchaseRepository;

    @Override
    public Purchase makePurchase(PurchaseDTO purchaseDTO) {
        ArrayList<PurchasedArticle> items = new ArrayList<>();

        for(int i = 0; i < purchaseDTO.getArticlesBought().size(); i++){
            Long itemID = purchaseDTO.getArticlesBought().get(i);
            Integer itemCount = purchaseDTO.getArticlesCount().get(i);

            PurchasedArticle newArticle = new PurchasedArticle(itemID, itemCount);
            items.add(newArticle);
        }

        Customer customer = userRepository.findCustomer(purchaseDTO.getUserEmail());
        Purchase newPurchase = new Purchase(items, customer);

        Purchase retPurchase = purchaseRepository.save(newPurchase);
        return retPurchase;
    }
}
