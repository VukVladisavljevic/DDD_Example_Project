package com.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.value_objects.Price;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
public class Purchase {

    @Id
    @GeneratedValue
    private long id;

    @JsonManagedReference(value="customer_purchasedArticles")
    @OneToMany(mappedBy = "purchase", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Collection<PurchasedArticle> articlesContained;

    @Embedded
    private Price price;

    @JsonBackReference(value="customer_purchases")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customerID")
    private Customer customer;

    public Purchase() {}

    public Purchase(Collection<PurchasedArticle> articlesContained, Customer customer) {
        for(PurchasedArticle article : articlesContained) {
            article.setPurchase(this);
        }

        this.articlesContained = articlesContained;
        this.setCustomer(customer);
    }

    public Collection<PurchasedArticle> getArticlesContained() {
        return articlesContained;
    }

    public void setArticlesContained(ArrayList<PurchasedArticle> articlesContained) {
        this.articlesContained = articlesContained;
    }


    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
