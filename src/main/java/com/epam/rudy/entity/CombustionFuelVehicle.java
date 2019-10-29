package com.epam.rudy.entity;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    include = JsonTypeInfo.As.PROPERTY,
    property = "type")
@JsonSubTypes({
    @JsonSubTypes.Type(value = FuelCar.class, name = "fuelCar"),
    @JsonSubTypes.Type(value = Bus.class, name = "bus"),
    @JsonSubTypes.Type(value = Minibus.class, name = "minibus"),
    @JsonSubTypes.Type(value = HouseOnWheels.class, name = "houseOnWheels")
})
public abstract class CombustionFuelVehicle extends EngineVehicle {

    /**  */
    private final int engineCapacity;

    /**  */
    @JsonIgnore
    private boolean isEngineEcoTestPassed;

    @JsonCreator
    public CombustionFuelVehicle(@JsonProperty("id") String id,
        @JsonProperty("vehicleType") VehicleType vehicleType,
        @JsonProperty("model") String model,
        @JsonProperty("yearOfManufacture") int yearOfManufacture,
        @JsonProperty("enginePower") int enginePower,
        @JsonProperty("carBodyType") CarBodyType carBodyType,
        @JsonProperty("engineCapacity") int engineCapacity) {
        super(id, vehicleType, model, yearOfManufacture, enginePower, carBodyType);
        this.engineCapacity = engineCapacity;
    }

    public CombustionFuelVehicle(VehicleType vehicleType,
                                 String model,
                                 int yearOfManufacture,
                                 int enginePower,
                                 CarBodyType carBodyType,
                                 int engineCapacity) {
        super(vehicleType, model, yearOfManufacture, enginePower,carBodyType);
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
