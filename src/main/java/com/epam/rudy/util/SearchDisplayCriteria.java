package com.epam.rudy.util;

import com.epam.rudy.entity.VehicleType;

public class SearchDisplayCriteria
{

    private String vehicleId;

    private String vehicleModel;

    private VehicleType vehicleType;

    private SearchDisplayCriteria(SearchCriteriaBuilder builder) {
        this.vehicleId = builder.vehicleId;
        this.vehicleModel = builder.vehicleModel;
        this.vehicleType = builder.vehicleType;
    }

    public static class SearchCriteriaBuilder {
        private String vehicleId;
        private String vehicleModel;
        private VehicleType vehicleType;

        public SearchCriteriaBuilder() {}

        public SearchCriteriaBuilder withVehicleId(String vehicleId) {
            this.vehicleId = vehicleId;
            return this;
        }

        public SearchCriteriaBuilder withVehicleModel(String vehicleModel) {
            this.vehicleModel = vehicleModel;
            return this;
        }

        public SearchCriteriaBuilder withVehicleType(VehicleType vehicleType) {
            this.vehicleType = vehicleType;
            return this;
        }

        public SearchDisplayCriteria build() {
            SearchDisplayCriteria sc = new SearchDisplayCriteria(this);
            return sc;
        }
    }
}
