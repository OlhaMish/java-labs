package com.olechok.vehicles;

import com.olechok.people.Human;

public class Auto<T extends Human> extends Vehicle<T> {
    public Auto(int maxSeats) {
        super(maxSeats);
    }
}
