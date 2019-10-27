package com.epam.rudy.dao;

import java.util.List;

import com.epam.rudy.entity.Vehicle;

public interface CRUD {

    Vehicle create(Vehicle vehicle);

    Vehicle retrieve(String id);

    List<Vehicle> retrieveAll();

    Vehicle update(String id);

    void delete(String id);

    void deleteAll();
}
