package com.epam.rudy.dao;

import java.io.IOException;
import java.util.List;

import com.epam.rudy.dao.exception.EntityNotFoundException;
import com.epam.rudy.entity.Vehicle;

public interface CRUD {

    Vehicle create(Vehicle vehicle) throws Exception;

    Vehicle retrieve(String id) throws EntityNotFoundException, IOException;

    List<Vehicle> retrieveAll() throws Exception;

    Vehicle update(String id) throws Exception;

    void delete(String id) throws EntityNotFoundException, IOException;

    void deleteAll() throws Exception;
}
