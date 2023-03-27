package com.javatechie.Entity;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@DynamoDBDocument
@AllArgsConstructor
@NoArgsConstructor
public class Address implements Serializable {
        @DynamoDBAttribute
        private String city;
        @DynamoDBAttribute
        private String state;
        @DynamoDBAttribute
        private Long pincode;
}
