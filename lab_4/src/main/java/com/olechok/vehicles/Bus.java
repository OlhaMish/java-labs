package com.olechok.vehicles;

import com.olechok.people.Human;

public class Bus<T extends Human> extends Vehicle<T> {
    public Bus(int maxSeats) {
        super(maxSeats);
    }
}
