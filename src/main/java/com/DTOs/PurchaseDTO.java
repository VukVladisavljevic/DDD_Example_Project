package com.DTOs;

import java.util.ArrayList;

public class PurchaseDTO {

    private ArrayList<Long> articlesBought;
    private ArrayList<Integer> articlesCount;
    private String userEmail;

    public PurchaseDTO() {}

    public PurchaseDTO(ArrayList<Long> articlesBought, ArrayList<Integer> articlesCount, String userEmail) {
        this.articlesBought = articlesBought;
        this.articlesCount = articlesCount;
        this.userEmail = userEmail;
    }

    public ArrayList<Long> getArticlesBought() {
        return articlesBought;
    }

    public void setArticlesBought(ArrayList<Long> articlesBought) {
        this.articlesBought = articlesBought;
    }

    public ArrayList<Integer> getArticlesCount() {
        return articlesCount;
    }

    public void setArticlesCount(ArrayList<Integer> articlesCount) {
        this.articlesCount = articlesCount;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
}
