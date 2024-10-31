package com.olechok.vehicles;

import com.olechok.people.Human;

public class Taxi<T extends Human> extends Auto<T> {
    public Taxi(int maxSeats) {
        super(maxSeats);
    }
}
