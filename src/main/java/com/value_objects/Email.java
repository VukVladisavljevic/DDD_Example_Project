package com.value_objects;

import com.exceptions.DomainException;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Embeddable
public class Email implements Comparable<Email> {

    @Column(name = "email")
    private final String value;

    public Email() {
        this.value = null;
    }

    public Email( String value) {

        if (!isValid(value)) {
            throw new DomainException("Not a valid Email value. Got " + value + ".");
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
    public int compareTo(Email email) {
        return 0;
    }
}
