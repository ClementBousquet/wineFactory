package dev.clement.wine.model;

public record ClientRequest(
        String email,
        String firstname,
        String lastname,
        String phoneNumber) {
}
