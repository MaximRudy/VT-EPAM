package com.epam.rudy.dao;

import java.util.List;

import com.epam.rudy.entity.Vehicle;
import com.epam.rudy.entity.VehicleType;

public interface VehicleDAO extends CRUD {

    List<Vehicle> retrieveByModel(String model);

    List<Vehicle> retrieveByYear(int year);
}
