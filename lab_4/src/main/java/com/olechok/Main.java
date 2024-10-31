package com.olechok;
import com.olechok.people.Firefighter;
import com.olechok.people.Human;
import com.olechok.people.PoliceOfficer;
import com.olechok.vehicles.*;


public class Main {
    public static void main(String[] args) {
        try {
            Road road = new Road();

            Bus<Human> bus = new Bus<>(10);
            Taxi<Human> taxi = new Taxi<>(3);
            FireTruck<Firefighter> fireTruck = new FireTruck<>(2);
            PoliceCar<PoliceOfficer> policeCar = new PoliceCar<>(2);

            Human passenger1 = new Human();
            Human passenger2 = new Human();
            Human passenger3 = new Human();
            Firefighter firefighter = new Firefighter();
            PoliceOfficer policeOfficer1 = new PoliceOfficer();
            PoliceOfficer policeOfficer2 = new PoliceOfficer();

            bus.boardPassenger(passenger1);
            bus.boardPassenger(passenger2);
            taxi.boardPassenger(passenger3);
            fireTruck.boardPassenger(firefighter);
            policeCar.boardPassenger(policeOfficer1);
            policeCar.boardPassenger(policeOfficer2);

            System.out.println("Total number of people on the road: " + road.getCountOfHumans());

            road.addCarToRoad(bus);
            road.addCarToRoad(taxi);
            road.addCarToRoad(fireTruck);
            road.addCarToRoad(policeCar);

            System.out.println("Total number of people on the road: " + road.getCountOfHumans());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}