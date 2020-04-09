package com.my.learning.controller;

import com.example.tutorial.AddressBookProtos;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String hello() {
        return "Hello Spring Boot!";
    }

    @RequestMapping(value = "/demo/test", produces = "application/x-protobuf")
    @ResponseBody
    public AddressBookProtos.AddressBook getAddressBook() {
        AddressBookProtos.Person person = AddressBookProtos.Person.newBuilder()
                .setName("name222222")
                .setId(2222222)
                .addPhones(AddressBookProtos.Person.PhoneNumber.newBuilder().setNumber("aaaaaaaaaaaa").build())
                .build();
        AddressBookProtos.AddressBook addressBook = AddressBookProtos.AddressBook.newBuilder()
                .addPeople(person)
                .build();
        return addressBook;
    }
}
