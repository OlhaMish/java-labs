package com.olechok.vehicles;
import com.olechok.people.Human;

import java.util.ArrayList;
import java.util.List;


public abstract class Vehicle<T extends Human> {
    private final int maxSeats;
    private final List<T> passengers;

    public Vehicle(int maxSeats) {
        this.maxSeats = maxSeats;
        this.passengers = new ArrayList<>();
    }

    public int getMaxSeats() {
        return maxSeats;
    }

    public int getOccupiedSeats() {
        return passengers.size();
    }

    public void boardPassenger(T passenger) throws Exception {
        if (passengers.size() >= maxSeats) {
            throw new Exception("No more seats available!");
        }
        if (passengers.contains(passenger)) {
            throw new Exception("Passenger is already occupied!");
        }
        passengers.add(passenger);
    }

    public void disembarkPassenger(T passenger) throws Exception {
        if (!passengers.contains(passenger)) {
            throw new Exception("Passenger is not on board!");
        }
        passengers.remove(passenger);
    }
}










