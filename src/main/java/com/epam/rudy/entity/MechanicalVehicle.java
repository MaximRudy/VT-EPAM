package com.epam.rudy.entity;

import java.util.Objects;

public abstract class MechanicalVehicle extends Vehicle {

    /**  */
    private final boolean isIndependentVehicle;

    /**  */
    private boolean isLightingSystemGood;

    public MechanicalVehicle(String id,
                             VehicleType type,
                             String model,
                             int yearOfManufacture,
                             boolean isIndependentVehicle) {
        super(id, type, model, yearOfManufacture);
        this.isIndependentVehicle = isIndependentVehicle;
    }

    public MechanicalVehicle(VehicleType type,
                             String model,
                             int yearOfManufacture,
                             boolean isIndependentVehicle) {
        super(type, model, yearOfManufacture);
        this.isIndependentVehicle = isIndependentVehicle;
    }

    public boolean isIndependentVehicle() { return isIndependentVehicle; }

    public boolean isLightingSystemGood() {
        return isLightingSystemGood;
    }

    public void setLightingSystemGood(boolean lightingSystemGood) {
        isLightingSystemGood = lightingSystemGood;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof MechanicalVehicle))
            return false;
        if (!super.equals(o))
            return false;
        MechanicalVehicle that = (MechanicalVehicle) o;
        return isIndependentVehicle == that.isIndependentVehicle;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), isIndependentVehicle);
    }

    @Override
    public String toString() {
        return super.toString() + ", isIndependentVehicle='" + isIndependentVehicle + '\'';
    }
}
