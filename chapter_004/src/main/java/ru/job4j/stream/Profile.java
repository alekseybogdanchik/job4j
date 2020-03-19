package ru.job4j.stream;

import java.util.List;
import java.util.stream.Collectors;

public class Profile {
    private Address address;

    public Profile(Address address) {
        this.address = address;
    }

    public List<Address> collect(List<Profile> profiles) {
        List<Address> addresses = profiles.stream().map(
                profile -> profile.address
        ).collect(Collectors.toList());
    return addresses;
    }
}
