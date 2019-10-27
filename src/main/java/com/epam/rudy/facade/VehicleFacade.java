package com.epam.rudy.facade;

import com.epam.rudy.entity.Vehicle;
import com.epam.rudy.service.VehicleService;
import com.epam.rudy.util.ConsoleUtil;
import com.epam.rudy.util.SearchDisplayCriteria;

import java.util.List;
import java.util.Objects;

/**
 *
 */
public class VehicleFacade {

    /**  */
    private VehicleService vehicleService = new VehicleService();

    /**
     *
     */
    public void takeControl() {
        boolean stopExecution = false;
        SearchDisplayCriteria criteria = null;
        while(!stopExecution) {
            int userInput = ConsoleUtil.processUserInitialInput();
            switch (userInput) {
                case 0:
                    criteria = ConsoleUtil.processUserInput4Display();
                    stopExecution = criteria.isCriteriaEmpty();
                    if (!stopExecution)
                        displayVehicles(criteria);
                    break;
                case 1:
                    Vehicle vehicle = ConsoleUtil.processUserInput4Creation();
                    stopExecution = Objects.isNull(vehicle);
                    if (!stopExecution)
                        addVehicle(vehicle);
                    break;
                case 2:
                    criteria = ConsoleUtil.processUserInput4Search();
                    stopExecution = criteria.isCriteriaEmpty();
                    if (!stopExecution)
                        findVehicles(criteria);
                    break;
                case 3:
                    criteria = ConsoleUtil.processUserInput4UpdateDelete("update");
                    stopExecution = criteria.isCriteriaEmpty();
                     if (!stopExecution)
                         updateVehicle(criteria);
                    break;
                case 4:
                    criteria = ConsoleUtil.processUserInput4UpdateDelete("delete");
                    stopExecution = criteria.isCriteriaEmpty();
                    if (!stopExecution)
                        vehicleService.deleteVehicleById(criteria.getVehicleId());
                    break;
                default:
                    stopExecution = true;
                    break;
            }
            if(!stopExecution)
                ConsoleUtil.printAppWelcomeMessage();
        }
    }

    private void displayVehicles(SearchDisplayCriteria criteria) {
        try {
            List<Vehicle> vehicles = vehicleService.displayAllAvailableVehicles(criteria);
            System.out.println("Here are all of your vehicles:");
            vehicles.stream().forEach(System.out::println);
        } catch (Exception ex) {
            System.out.println("Ups... something went wrong. Please try again");
        }
    }

    private void addVehicle(Vehicle vehicle) {
        try {
            vehicleService.addNewVehicle(vehicle);
            System.out.println("Your vehicle was successfully added!\n" + vehicle);
        } catch (Exception ex) {
            System.out.println("Ups... something went wrong. Please try again");
        }
    }

    private void findVehicles(SearchDisplayCriteria criteria) {
        try {
            List<Vehicle> vehicles = vehicleService.findVehicleBySearchCriteria(criteria);
            System.out.println("Here are the vehicles found:");
            vehicles.stream().forEach(System.out::println);
        } catch (Exception ex) {
            System.out.println("Ups... something went wrong. Please try again");
        }
    }

    private void updateVehicle(SearchDisplayCriteria criteria) {
        try {
            Vehicle vehicle = vehicleService.updateVehicleModelById(criteria.getVehicleId(), criteria.getVehicleModel());
        } catch (Exception ex) {
            System.out.println("Ups... something went wrong. Please try again");
        }
    }

    private void deleteVehicle(SearchDisplayCriteria criteria) {
        try {

        } catch (Exception ex) {
            System.out.println("Ups... something went wrong. Please try again");
        }
    }
}
