package com.value_objects;

import com.exceptions.DomainException;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Price implements Comparable<Price>{

    @Column(name = "price")
    private final double value;

    public Price() {
        this.value = 0;
    }

    public Price(final double value) {

        if (!isValid(value)) {
            throw new DomainException("Price value not valid. Got " + value);
        }
        this.value = value;

    }

    private boolean isValid(double value) {
        if(value <= 0 || value >= 100000) {
            return false;
        }

        return true;
    }

    public double getValue() {
        return value;
    }


    @Override
    public int compareTo(Price price) {
        return 0;
    }
}
