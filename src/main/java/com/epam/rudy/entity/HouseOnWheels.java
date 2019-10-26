package com.epam.rudy.entity;

import java.util.Objects;
import java.util.Random;

public class HouseOnWheels extends CombustionFuelVehicle {

    /**  */
    private final boolean isKitchenPresent;

    public HouseOnWheels(String id,
                         String model,
                         int yearOManufacture,
                         int enginePower,
                         int engineCapacity,
                         boolean isKitchenPresent) {
        super(id, VehicleType.HOUSE_ON_WHEELS, model, yearOManufacture, enginePower, engineCapacity);
        this.isKitchenPresent = isKitchenPresent;
    }

    public HouseOnWheels(String model,
                         int yearOManufacture,
                         int enginePower,
                         int engineCapacity,
                         boolean isKitchenPresent) {
        super(VehicleType.HOUSE_ON_WHEELS, model, yearOManufacture, enginePower, engineCapacity);
        this.isKitchenPresent = isKitchenPresent;
    }

    @Override
    protected void doInitialPreparation() {
        checkEngine();
    }

    private void checkEngine() {
        Random rand = new Random();
        setEngineEcoTestPassed((rand.nextInt() % 2 == 0) ? true : false);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof HouseOnWheels))
            return false;
        if (!super.equals(o))
            return false;
        HouseOnWheels that = (HouseOnWheels) o;
        return isKitchenPresent == that.isKitchenPresent;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), isKitchenPresent);
    }

    @Override
    public String toString() {
        return "HouseOnWheels{" + super.toString() + ", isKitchenPresent'=" + isKitchenPresent + "'}";
    }
}
