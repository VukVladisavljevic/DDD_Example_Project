package com.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.value_objects.*;
import javassist.runtime.Desc;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Article {

    @Id
    @GeneratedValue
    private long id;

    @Embedded
    private Title title;

    @Embedded
    private Description description;

    @Embedded
    private Writer writer;

    @Embedded
    private Year publishingYear;

    @Embedded
    private Price price;

    @Embedded
    private Quantity units;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Collection<Purchase> purchases;

    public Article() {
    }

    public Article(String title, String description, String writer, int publishingYear, double price, int units) {
        this.title = new Title(title);
        this.description = new Description(description);
        this.writer = new Writer(writer);
        this.publishingYear = new Year(publishingYear);
        this.price = new Price(price);
        this.units = new Quantity(units);
        this.purchases = new ArrayList<>();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Title getTitle() {
        return title;
    }

    public void setTitle(Title title) {
        this.title = title;
    }

    public Description getDescription() {
        return description;
    }

    public void setDescription(Description description) {
        this.description = description;
    }

    public Writer getWriter() {
        return writer;
    }

    public void setWriter(Writer writer) {
        this.writer = writer;
    }

    public Year getPublishingYear() {
        return publishingYear;
    }

    public void setPublishingYear(Year publishingYear) {
        this.publishingYear = publishingYear;
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public Quantity getUnits() {
        return units;
    }

    public void setUnits(Quantity units) {
        this.units = units;
    }

    public Collection<Purchase> getPurchases() {
        return purchases;
    }

    public void setPurchases(Collection<Purchase> purchases) {
        this.purchases = purchases;
    }
}
