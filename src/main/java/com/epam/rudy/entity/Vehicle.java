package com.epam.rudy.entity;

import java.util.IllegalFormatException;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.epam.rudy.util.JournalHelper;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 */
public abstract class Vehicle implements Registrable, Comparable, Cloneable {

    /** Journal helper singleton instance */
    public static final JournalHelper JOURNAL_HELPER = JournalHelper.getInstance();

    /**  */
    private String id;

    /**  */
    private final VehicleType vehicleType;

    // Omitting final keyword here in order to be able to update this field
    private String model;

    /**  */
    private final int yearOfManufacture;

    @JsonCreator
    protected Vehicle(@JsonProperty("id") String id,
                      @JsonProperty("vehicleType") VehicleType vehicleType,
                      @JsonProperty("model") String model,
                      @JsonProperty("yearOfManufacture") int yearOfManufacture) {
        this(vehicleType, model, yearOfManufacture);
        this.id = id;
    }

    protected Vehicle(VehicleType vehicleType,
                      String model,
                      int yearOfManufacture) {
        this.vehicleType = vehicleType;
        this.model = model;
        this.yearOfManufacture = yearOfManufacture;
        postConstruct();
    }

    private void postConstruct() {
        registerInJournal();
        doInitialPreparation();
    }

    private void registerInJournal() {
        JOURNAL_HELPER.register(this);
    }

    @Override
    public String stringifyForRegistering(String delimiter) {
        return String.format(toString() + "\\n%s\\n", delimiter);
    }

    /**
     * Subclasses to determine the exact kind of initial preparation to be done
     * for every concrete vehicle implementation.
     */
    protected abstract void doInitialPreparation();

    public String getId() { return id; }

    public void setId(String id) { this.id = id; }

    public void setModel(String model) {
        this.model = model;
    }

    public VehicleType getType() { return vehicleType; }

    public String getModel() { return model; }

    public int getYearOfManufacture() { return yearOfManufacture; }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Vehicle))
            return false;
        Vehicle vehicle = (Vehicle) o;
        return yearOfManufacture == vehicle.yearOfManufacture &&
            id.equals(vehicle.id) &&
            vehicleType == vehicle.vehicleType &&
            model.equals(vehicle.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, vehicleType, model, yearOfManufacture);
    }

    @Override
    public String toString() {
        return "id='" + id + "'" +
            ", vehicleType=" + vehicleType +
            ", model='" + model + '\'' +
            ", yearOfManufacture='" + yearOfManufacture + '\'';
    }

    @Override
    public int compareTo(Object o) {
        return this.getId().compareTo(((Vehicle) o).id);
    }

    public Object clone()throws CloneNotSupportedException{
        return super.clone();
    }
}
