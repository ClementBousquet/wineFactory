package dev.clement.wine.model;

import dev.clement.wine.entity.Client;

public record ClientResponse(String email,
                             String firstname,
                             String lastname,
                             String phoneNumber) {

    public static ClientResponse from(Client client) {
        return new ClientResponse(client.getEmail(), client.getFirstname(), client.getLastname(), client.getPhoneNumber());
    }
}
