package com.olechok;

import com.olechok.people.Human;
import com.olechok.people.Firefighter;
import com.olechok.people.PoliceOfficer;
import com.olechok.vehicles.Bus;
import com.olechok.vehicles.FireTruck;
import com.olechok.vehicles.PoliceCar;
import com.olechok.vehicles.Taxi;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoadTest {

    private Road road;
    private Bus<Human> bus;
    private Taxi<Human> taxi;
    private FireTruck<Firefighter> firetruck;
    private PoliceCar<PoliceOfficer> policeCar;

    @BeforeEach
    void setUp() {
        road = new Road();
        bus = new Bus<>(3);
        taxi = new Taxi<>(2);
        firetruck = new FireTruck<>(2);
        policeCar = new PoliceCar<>(1);
    }

    @Test
    void testAddCarToRoad() throws Exception {
        road.addCarToRoad(bus);
        assertEquals(0, road.getCountOfHumans());
    }

    @Test
    void testAddDuplicateCarToRoad() {
        Exception exception = assertThrows(Exception.class, () -> {
            road.addCarToRoad(bus);
            road.addCarToRoad(bus);
        });
        assertEquals("Car is already in the road!", exception.getMessage());
    }

    @Test
    void testGetCountOfHumans() throws Exception {
        bus.boardPassenger(new Human());
        taxi.boardPassenger(new Human());

        road.addCarToRoad(bus);
        road.addCarToRoad(taxi);

        assertEquals(2, road.getCountOfHumans());
    }

    @Test
    void testRemoveCarFromRoad() throws Exception {
        road.addCarToRoad(bus);
        road.removeCarFromRoad(bus);
        assertEquals(0, road.getCountOfHumans());
    }

    @Test
    void testRemoveNonexistentCarFromRoad() {
        Exception exception = assertThrows(Exception.class, () -> road.removeCarFromRoad(bus));
        assertEquals("Car is not in the road!", exception.getMessage());
    }
}
