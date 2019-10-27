package com.epam.rudy.service;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

import com.epam.rudy.dao.VehicleDAO;
import com.epam.rudy.dao.impl.VehicleDAOFileImpl;
import com.epam.rudy.entity.Vehicle;
import com.epam.rudy.util.SearchDisplayCriteria;
import com.epam.rudy.util.comparator.VehicleModelComparator;
import com.epam.rudy.util.comparator.VehicleYearOfManufactureComparator;

public class VehicleService {

    /**  */
    private VehicleDAO vehicleDAO = new VehicleDAOFileImpl();

    public List<Vehicle> displayAllAvailableVehicles(SearchDisplayCriteria criteria) {
        List<Vehicle> vehicleList = vehicleDAO.retrieveAll();
        if(criteria.isCriteriaEmpty() || Objects.nonNull(criteria.getVehicleId())) {
            Collections.sort(vehicleList);
        } else if(Objects.nonNull(criteria.getVehicleModel())) {
            Collections.sort(vehicleList, new VehicleModelComparator());
        } else {
            Collections.sort(vehicleList, new VehicleYearOfManufactureComparator());
        }
        return vehicleList;
    }

    public Vehicle addNewVehicle(Vehicle vehicle) {
        return vehicleDAO.create(vehicle);
    }

    public List<Vehicle> findVehicleBySearchCriteria(SearchDisplayCriteria criteria) {
        List<Vehicle> vehicleList = new ArrayList<>();
        if(Objects.nonNull(criteria.getVehicleId())) {
            vehicleList.add(vehicleDAO.retrieve(criteria.getVehicleId()));
        } else if(Objects.nonNull(criteria.getVehicleModel())) {
            vehicleList.addAll(vehicleDAO.retrieveByModel(criteria.getVehicleModel()));
        } else if(Objects.nonNull(criteria.getYearOfManufacture())) {
            vehicleList.addAll(vehicleDAO.retrieveByYear(criteria.getYearOfManufacture()));
        }
        return vehicleList;
    }

    public Vehicle updateVehicleModelById(String vehicleId, String vehicleModel) throws CloneNotSupportedException {
        Vehicle originalVehicle = vehicleDAO.retrieve(vehicleId);
        Vehicle updatedVehicle = (Vehicle) originalVehicle.clone();
        updatedVehicle.setModel(vehicleModel);
        vehicleDAO.delete(vehicleId);
        return vehicleDAO.create(updatedVehicle);
    }

    public void deleteVehicleById(String vehicleId) {
        vehicleDAO.delete(vehicleId);
    }
}
