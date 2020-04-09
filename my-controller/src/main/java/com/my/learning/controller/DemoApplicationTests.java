package com.my.learning.controller;

import com.example.tutorial.AddressBookProtos;
import com.google.protobuf.util.JsonFormat;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.URI;

//@RunWith(SpringRunner.class)
//@SpringBootTest
public class DemoApplicationTests {

    public static void main(String[] args) {
        try {
            URI uri = new URI("http", null, "127.0.0.1", 8080, "/demo/test", "", null);
            HttpPost request = new HttpPost(uri);
            AddressBookProtos.Person person = AddressBookProtos.Person.newBuilder()
                    .setName("name")
                    .setId(1111)
                    .addPhones(AddressBookProtos.Person.PhoneNumber.newBuilder().setNumber("222222222").build())
                    .build();
            AddressBookProtos.AddressBook addressBook = AddressBookProtos.AddressBook.newBuilder()
                    .addPeople(person)
                    .build();
            HttpResponse response = HttpUtils.doPost(request, addressBook);
            AddressBookProtos.AddressBook book = AddressBookProtos.AddressBook.parseFrom(response.getEntity().getContent());
            System.out.println("==============================");
            System.out.println(JsonFormat.printer().print(book));
            System.out.println("==============================");
        } catch (Exception e) {
e.printStackTrace();
        }
    }
}
