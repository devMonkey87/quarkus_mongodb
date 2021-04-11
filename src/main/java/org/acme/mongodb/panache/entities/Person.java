package org.acme.mongodb.panache.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.quarkus.mongodb.panache.PanacheMongoEntity;

import javax.transaction.Status;
import java.time.LocalDate;

public class Person extends PanacheMongoEntity {
    @JsonProperty
    public String name;
    public String status;
    public int account;
}
