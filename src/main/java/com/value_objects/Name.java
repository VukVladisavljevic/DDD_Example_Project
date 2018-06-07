package com.value_objects;

import com.exceptions.DomainException;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Embeddable
public class Name implements Comparable<Name> {

    @Column(name = "name")
    private final String value;

    public Name() {
        this.value = null;
    }
    public Name( String value) {

        if (!isValid(value)) {
            throw new DomainException("Not a valid name value. Got " + value + ".");
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
    public int compareTo(Name name) {
        return 0;
    }
}
