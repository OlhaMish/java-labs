package com.olechok;

import com.olechok.people.Firefighter;
import com.olechok.people.Human;
import com.olechok.people.PoliceOfficer;

import com.olechok.vehicles.Bus;
import com.olechok.vehicles.FireTruck;
import com.olechok.vehicles.PoliceCar;
import com.olechok.vehicles.Taxi;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class VehicleTest {
    private Bus<Human> bus;
    private Taxi<Human> taxi;
    private FireTruck<Firefighter> fireTruck;
    private PoliceCar<PoliceOfficer> policeCar;

    @BeforeEach
    public void setUp() {
        bus = new Bus<>(3);
        taxi = new Taxi<>(2);
        fireTruck = new FireTruck<>(1);
        policeCar = new PoliceCar<>(1);
    }

    @Test
    public void testFillingBusWithPassengers() throws Exception {
        Human passenger1 = new Human();
        Human passenger2 = new Human();
        Firefighter firefighter = new Firefighter();

        bus.boardPassenger(passenger1);
        bus.boardPassenger(passenger2);
        bus.boardPassenger(firefighter);

        assertEquals(3, bus.getOccupiedSeats());
    }

    @Test
    public void testFillingTaxiWithPassengers() throws Exception {
        Human passenger1 = new Human();
        PoliceOfficer policeOfficer = new PoliceOfficer();

        taxi.boardPassenger(passenger1);
        taxi.boardPassenger(policeOfficer);

        assertEquals(2, taxi.getOccupiedSeats());
    }

    @Test
    public void testFillingFireTruckWithFirefighters() throws Exception {
        Firefighter firefighter = new Firefighter();

        fireTruck.boardPassenger(firefighter);

        assertEquals(1, fireTruck.getOccupiedSeats());
    }

    @Test
    public void testFillingPoliceCarWithPoliceOfficer() throws Exception {
        PoliceOfficer policeOfficer = new PoliceOfficer();

        policeCar.boardPassenger(policeOfficer);

        assertEquals(1, policeCar.getOccupiedSeats());
    }

    @Test
    public void testMaxCapacityException() {
        Human passenger1 = new Human();
        Human passenger2 = new Human();
        Human passenger3 = new Human();
        Human passenger4 = new Human();

        try {
            bus.boardPassenger(passenger1);
            bus.boardPassenger(passenger2);
            bus.boardPassenger(passenger3);
        } catch (Exception e) {
            fail("Unexpected exception when filling up to max capacity");
        }

        Exception exception = assertThrows(Exception.class, () -> bus.boardPassenger(passenger4));
        assertEquals("No more seats available!", exception.getMessage());
    }

    @Test
    public void testDisembarkPassenger() throws Exception {
        Human passenger = new Human();
        bus.boardPassenger(passenger);

        assertEquals(1, bus.getOccupiedSeats());

        bus.disembarkPassenger(passenger);
        assertEquals(0, bus.getOccupiedSeats());
    }

    @Test
    public void testDisembarkPassengerNotInVehicle() {
        Human passenger = new Human();

        Exception exception = assertThrows(Exception.class, () -> bus.disembarkPassenger(passenger));
        assertEquals("Passenger is not on board!", exception.getMessage());
    }

    @Test
    void testBoardDuplicatePassenger() throws Exception {
        Human passenger = new Human();
        bus.boardPassenger(passenger);
        Exception exception = assertThrows(Exception.class, () -> bus.boardPassenger(passenger));
        assertEquals("Passenger is already occupied!", exception.getMessage());
    }
}
