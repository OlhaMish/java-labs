package com.olechok.vehicles;

import com.olechok.people.PoliceOfficer;

public class PoliceCar<T extends PoliceOfficer> extends Auto<T> {
    public PoliceCar(int maxSeats) {
        super(maxSeats);
    }
}