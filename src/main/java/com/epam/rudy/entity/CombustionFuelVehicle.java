package com.epam.rudy.entity;

import java.util.Objects;

public abstract class CombustionFuelVehicle extends EngineVehicle {

    /**  */
    private final int engineCapacity;

    /**  */
    private boolean isEngineEcoTestPassed;

    public CombustionFuelVehicle(String id,
                                 VehicleType vehicleType,
                                 String model,
                                 int yearOManufacture,
                                 int enginePower,
                                 CarBodyType carBodyType,
                                 int engineCapacity) {
        super(id, vehicleType, model, yearOManufacture, enginePower, carBodyType);
        this.engineCapacity = engineCapacity;
    }

    public CombustionFuelVehicle(VehicleType vehicleType,
                                 String model,
                                 int yearOManufacture,
                                 int enginePower,
                                 CarBodyType carBodyType,
                                 int engineCapacity) {
        super(vehicleType, model, yearOManufacture, enginePower,carBodyType);
        this.engineCapacity = engineCapacity;
    }

    public int getEngineCapacity() {
        return engineCapacity;
    }

    public boolean isEngineEcoTestPassed() {
        return isEngineEcoTestPassed;
    }

    protected void setEngineEcoTestPassed(boolean engineEcoTestPassed) {
        isEngineEcoTestPassed = engineEcoTestPassed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CombustionFuelVehicle)) return false;
        if (!super.equals(o)) return false;
        CombustionFuelVehicle that = (CombustionFuelVehicle) o;
        return engineCapacity == that.engineCapacity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), engineCapacity);
    }

    @Override
    public String toString() {
        return super.toString() + ", engineCapacity=" + engineCapacity + '\'';
    }
}
