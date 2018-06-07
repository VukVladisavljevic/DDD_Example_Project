package com.value_objects;

import com.exceptions.DomainException;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Embeddable
public class Surname implements Comparable<Surname>{

    @Column(name = "surname")
    private final String value;

    @SuppressWarnings("unused")
    public Surname() {
        this.value = null;
    }

    public Surname(String value) {

        if (!isValid(value)) {
            throw new DomainException("Not a valid surname value. Got " + value + ".");
        }

        this.value = value;

    }

    private boolean isValid(String value){

        if (value == null || value.trim().isEmpty()) {
            return false;
        }

        Pattern p = Pattern.compile("[^A-Za-z0-9]");
        Matcher m = p.matcher(value);

        boolean b = m.find();
        if (b) {
            return false;
        }
        return true;
    }


    @Override
    public int compareTo(Surname surname) {
        return 0;
    }
}
