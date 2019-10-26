package com.epam.rudy.service;

import java.util.Comparator;
import java.util.List;

import com.epam.rudy.dao.VehicleDAO;
import com.epam.rudy.dao.impl.VehicleDAOFileImpl;
import com.epam.rudy.entity.Vehicle;
import com.epam.rudy.util.SearchDisplayCriteria;

public class VehicleService {

    private VehicleDAO vehicleDAO = new VehicleDAOFileImpl();

    public List<Vehicle> displayAllAvailableVehicles(SearchDisplayCriteria criteria) {

    }

    public Vehicle addNewVehicle(Vehicle vehicle) {
        //VehicleFactory.createVehicle(userInput);
    }

    public Vehicle findVehicleBySearchCriteria(SearchDisplayCriteria criteria) {

    }

    public Vehicle updateVehicle(SearchDisplayCriteria criteria) {

    }

    public void deleteVehicleById(String vehicleId) {

    }
}
