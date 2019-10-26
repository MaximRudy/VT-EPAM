package com.epam.rudy.entity;

import java.util.Objects;

public abstract class ElectroVehicle extends EngineVehicle {

    /**  */
    private final int timeToCharge;

    /**  */
    private boolean isEngineCircuitPassRateGood;

    public ElectroVehicle(String id,
                          VehicleType vehicleType,
                          String model,
                          int yearOfManufacture,
                          int enginePower,
                          int timeToCharge) {
        super(id, vehicleType, model, yearOfManufacture, enginePower);
        this.timeToCharge = timeToCharge;
    }

    public ElectroVehicle(VehicleType vehicleType,
                          String model,
                          int yearOfManufacture,
                          int enginePower,
                          int timeToCharge) {
        super(vehicleType, model, yearOfManufacture, enginePower);
        this.timeToCharge = timeToCharge;
    }

    public int getTimeToCharge() {
        return timeToCharge;
    }

    public boolean isEngineCircuitPassRateGood() {
        return isEngineCircuitPassRateGood;
    }

    protected void setEngineCircuitPassRateGood(boolean engineCircuitPassRateGood) {
        isEngineCircuitPassRateGood = engineCircuitPassRateGood;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof ElectroVehicle))
            return false;
        if (!super.equals(o))
            return false;
        ElectroVehicle that = (ElectroVehicle) o;
        return timeToCharge == that.timeToCharge;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), timeToCharge);
    }

    @Override
    public String toString() {
        return super.toString() + ", timeToCharge='" + timeToCharge + '\'';
    }
}
