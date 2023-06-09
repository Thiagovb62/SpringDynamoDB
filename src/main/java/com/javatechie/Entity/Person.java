package com.javatechie.Entity;

import com.amazonaws.services.dynamodbv2.datamodeling.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@DynamoDBDocument
@AllArgsConstructor
@NoArgsConstructor
@DynamoDBTable(tableName = "person")
public class Person implements Serializable {

    @DynamoDBHashKey(attributeName = "personId")
    @DynamoDBAutoGeneratedKey
    private String personId;
    @DynamoDBAttribute
    private String personName;
    @DynamoDBAttribute
    private int age;
    @DynamoDBAttribute
    private String email;
    @DynamoDBAttribute
    private Address address;



}
