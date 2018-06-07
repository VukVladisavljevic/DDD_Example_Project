package com.value_objects;

import com.exceptions.DomainException;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Embeddable
public class Password implements Comparable<Password>{

    @Column(name = "password")
    private final String value;

    public Password () {
        this.value = null;
    }

    public Password(String pass){
        if (!isValid(pass)) {
            throw new DomainException("Not a valid password value. Got " + pass + ".");
        }

        this.value = pass;
    }

    private boolean isValid(String value){

        if (value == null || value.trim().isEmpty()) {
            return false;
        }

        if(value.length() <= 6 || value.length() >= 32){
            return false;
        }

        return true;

    }

    @Override
    public int compareTo(Password password) {
        return 0;
    }
}
