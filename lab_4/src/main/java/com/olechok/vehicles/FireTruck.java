package com.olechok.vehicles;

import com.olechok.people.Firefighter;

public class FireTruck<T extends Firefighter> extends Auto<T> {
    public FireTruck(int maxSeats) {
        super(maxSeats);
    }
}