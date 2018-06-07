package com.entities;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@PrimaryKeyJoinColumn(name="USER_ID")
@DiscriminatorValue("A")
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Admin extends User {
}
