package com.olechok;

import com.google.gson.Gson;

public class Main {
    public static void main(String[] args) {
        Person person = new Person("Міщук", "Оля", 19);

        Gson gson = new Gson();
        String personJson = gson.toJson(person);
        System.out.println("JSON: " + personJson);

        Person personFromJson = gson.fromJson(personJson, Person.class);
        System.out.println("Person from JSON: " +
                            personFromJson.getLastName() +
                            " " +
                            personFromJson.getFirstName() +
                            ", age: " +
                            personFromJson.getAge());

        boolean isEqual = person.equals(personFromJson);
        System.out.println("Equal? " + isEqual);
    }
}
