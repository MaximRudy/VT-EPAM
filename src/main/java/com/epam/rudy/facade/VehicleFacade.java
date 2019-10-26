package com.epam.rudy.facade;

import com.epam.rudy.service.VehicleService;
import com.epam.rudy.util.ConsoleUtil;

/**
 *
 */
public class VehicleFacade {

    /**  */
    private VehicleService vehicleService = new VehicleService();

    public void takeControl() {
        int userInput = ConsoleUtil.processUserInitialInput();
        switch (userInput) {
            case 0:
                vehicleService.displayAllAvailableVehicles(ConsoleUtil.processUserInput4Display());
                break;
            case 1:
                vehicleService.addNewVehicle(ConsoleUtil.processUserInput4Creation());
                break;
            case 2:
                vehicleService.findVehicleBySearchCriteria(ConsoleUtil.processUserInput4Search);
                break;
            case 3:
                vehicleService.updateVehicle(ConsoleUtil.processUserInput4Update());
                break;
            case 4:
                vehicleService.deleteVehicleById(ConsoleUtil.processUserInput4Delete);
                break;
            default:
                break;
        }
    }
}
