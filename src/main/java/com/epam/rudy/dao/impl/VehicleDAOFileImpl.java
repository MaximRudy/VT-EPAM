package com.epam.rudy.dao.impl;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import com.epam.rudy.dao.VehicleDAO;
import com.epam.rudy.entity.Vehicle;
import com.epam.rudy.entity.VehicleType;

public class VehicleDAOFileImpl implements VehicleDAO {

    /**  */
    private static AtomicInteger counter = new AtomicInteger(0);

    @Override
    public List<Vehicle> retrieveAll()
    {
        return null;
    }

    @Override
    public Vehicle create(Vehicle vehicle)
    {
        return null;
    }

    @Override
    public Vehicle retrieve(String id)
    {
        return null;
    }

    @Override
    public List<Vehicle> retrieveByModel(String model)
    {
        return null;
    }

    @Override
    public List<Vehicle> retrieveByYear(int year) {
        return null;
    }

    @Override
    public Vehicle update(String id)
    {
        return null;
    }

    @Override
    public void delete(String id) {

    }

    @Override
    public void deleteAll() {

    }
}
