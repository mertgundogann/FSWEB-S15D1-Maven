package org.example;

import org.example.mobile.Contact;
import org.example.models.Grocery;

import static org.example.models.Grocery.startGrocery;

public class Main {
    public static void main(String[] args) {
        startGrocery();
        Contact contact = Contact.createContact("Ali", "1234567890");


        System.out.println("İsim: " + contact.getName());
        System.out.println("Telefon Numarası: " + contact.getPhoneNumber());
    }
}
