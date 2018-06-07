package com.value_objects;

import com.exceptions.DomainException;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Embeddable
public class Year implements Comparable<Year> {

    @Column(name = "year")
    private final int value;

    public Year() {
        this.value = 0;
    }

    public Year( int value) {

        if (!isValid(value)) {
            throw new DomainException("Not a valid year value. Got " + value + ".");
        }

        this.value = value;
    }

    private boolean isValid(int value){
        if (value >= 2018 || value <= 0) {
            return false;
        }

        return true;
    }

    @Override
    public int compareTo(Year name) {
        return 0;
    }
}
