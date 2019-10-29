package com.epam.rudy.entity;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    include = JsonTypeInfo.As.PROPERTY,
    property = "type")
@JsonSubTypes({
    @JsonSubTypes.Type(value = ElectroVehicle.class, name = "electroVehicle"),
    @JsonSubTypes.Type(value = CombustionFuelVehicle.class, name = "combustionFuelVehicle")
})
public abstract class EngineVehicle extends Vehicle {

    /**  */
    private final int enginePower;

    /**  */
    private final CarBodyType carBodyType;

    @JsonCreator
    public EngineVehicle(@JsonProperty("id") String id,
        @JsonProperty("vehicleType") VehicleType vehicleType,
        @JsonProperty("model") String model,
        @JsonProperty("yearOfManufacture") int yearOfManufacture,
        @JsonProperty("enginePower") int enginePower,
        @JsonProperty("carBodyType") CarBodyType carBodyType) {
        super(id, vehicleType, model, yearOfManufacture);
        this.enginePower = enginePower;
        this.carBodyType = carBodyType;
    }

    public EngineVehicle(VehicleType vehicleType,
                         String model,
                         int yearOfManufacture,
                         int enginePower,
                         CarBodyType carBodyType) {
        super(vehicleType, model, yearOfManufacture);
        this.enginePower = enginePower;
        this.carBodyType = carBodyType;
    }

    public int getEnginePower() {
        return enginePower;
    }

    public CarBodyType getCarBodyType() {
        return carBodyType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof EngineVehicle))
            return false;
        if (!super.equals(o))
            return false;
        EngineVehicle that = (EngineVehicle) o;
        return enginePower == that.enginePower && carBodyType == that.carBodyType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), enginePower, carBodyType);
    }

    @Override
    public String toString() {
        return super.toString() + ", enginePower='" + enginePower + ", carBodyType='" + carBodyType + "\'";
    }
}
