package com.deus.app;

import com.deus.model.Contact;
import com.deus.service.ContactService;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:spring-config.xml");
        ctx.refresh();

        ContactService contactService = ctx.getBean("jpaContactService", ContactService.class);
        List<Contact> contacts = contactService.findAll();
        printAll(contacts);

        contacts = contactService.findByFirstName("Name1");
        printAll(contacts);

        contacts = contactService.findByFirstNameAndLastName("Name1", "LastName1");
        printAll(contacts);
    }

    private static void printAll(List<Contact> contacts) {
        System.out.println("printAll: ");
//        contacts.forEach(System.out::println);
        for (Contact contact : contacts) {
            System.out.println(contact);
        }
    }
}
