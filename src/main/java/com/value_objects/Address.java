package com.value_objects;

import com.exceptions.DomainException;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Embeddable
public class Address implements Comparable<Address>{

    @Column(name = "address")
    private final String value;

    public Address() {
        this.value = null;
    }

    public Address(String address){
        if (!isValid(address)) {
            throw new DomainException("Not a valid address value. Got " + address + ".");
        }

        this.value = address;
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
    public int compareTo(Address address) {
        return 0;
    }
}
