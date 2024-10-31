package com.olechok;
import com.olechok.people.Human;
import com.olechok.vehicles.Vehicle;

import java.util.ArrayList;
import java.util.List;


public class Road {
    private final List<Vehicle<? extends Human>> carsInRoad = new ArrayList<>();

    public void addCarToRoad(Vehicle<? extends Human> car) throws Exception {
        if (carsInRoad.contains(car)) {
            throw new Exception("Car is already in the road!");
        }
        carsInRoad.add(car);
    }

    public int getCountOfHumans() {
        int count = 0;
        for (Vehicle<? extends Human> vehicle : carsInRoad) {
            count += vehicle.getOccupiedSeats();
        }
        return count;
    }

    public void removeCarFromRoad(Vehicle<? extends Human> car) throws Exception {
        if (!carsInRoad.contains(car)) {
            throw new Exception("Car is not in the road!");
        }
        carsInRoad.remove(car);
    }
}

