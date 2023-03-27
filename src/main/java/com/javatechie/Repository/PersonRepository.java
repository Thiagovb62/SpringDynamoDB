package com.javatechie.Repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import com.javatechie.Entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class PersonRepository {

    @Autowired
    private DynamoDBMapper mapper;

    public Person save(Person person) {
        mapper.save(person);
        return person;
    }

    public Person getPersonById(String personId) {
        return mapper.load(Person.class, personId);
    }

    public String deletePerson(String personId) {
        mapper.delete(getPersonById(personId));
        return "Person removed !!";
    }

    public String updatePerson(Person person) {
        mapper.save(person, buildExpression(person));
        return "record updated ...";
    }

    //This method is used to verify the existence of the PersonId before updating the record
    private DynamoDBSaveExpression buildExpression(Person person) {
        DynamoDBSaveExpression saveExpression = new DynamoDBSaveExpression();
        Map<String, ExpectedAttributeValue> expected = new HashMap<>();
        expected.put("personId", new ExpectedAttributeValue(new AttributeValue().withS(person.getPersonId())));
        saveExpression.setExpected(expected);
        return saveExpression;
    }
}
