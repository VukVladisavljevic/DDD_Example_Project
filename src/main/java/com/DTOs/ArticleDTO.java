package com.DTOs;

public class ArticleDTO {

    private long id;
    private String title;
    private String description;
    private String writer;
    private int publishingYear;
    private double price;
    private int units;

    public ArticleDTO() {}

    public ArticleDTO(String title, String description, String writer, int publishingYear, double price, int units) {
        this.title = title;
        this.description = description;
        this.writer = writer;
        this.publishingYear = publishingYear;
        this.price = price;
        this.units = units;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public int getPublishingYear() {
        return publishingYear;
    }

    public void setPublishingYear(int publishingYear) {
        this.publishingYear = publishingYear;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getUnits() {
        return units;
    }

    public void setUnits(int units) {
        this.units = units;
    }
}
