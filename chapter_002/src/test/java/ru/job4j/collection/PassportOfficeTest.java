package ru.job4j.collection;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class PassportOfficeTest {

    @Test
    public void add() {
        Citizen citizen = new Citizen("2f44a", "Petr Arsentev");
        Citizen duplicate = new Citizen("2f44a", "Duplicate Passport");
        PassportOffice office = new PassportOffice();
        office.add(citizen);
        office.add(duplicate);
        assertThat(office.get(citizen.getPassport()), is(citizen));
    }
}