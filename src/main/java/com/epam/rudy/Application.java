package com.epam.rudy;

import java.io.IOException;
import java.util.Scanner;

import com.epam.rudy.entity.FuelCar;
import com.epam.rudy.entity.Vehicle;
import com.epam.rudy.facade.VehicleFacade;
import com.epam.rudy.util.ConsoleUtil;

/**
 *
 */
public class Application
{
    public static void main(String args[]) throws IOException {

        boolean stopApplication = false;
        VehicleFacade vehicleFacade = new VehicleFacade();

        while(!stopApplication) {
            ConsoleUtil.printAppWelcomeMessage();

            vehicleFacade.takeControl();

            ConsoleUtil.printAppWelcomeMessage();
            if (ConsoleUtil.processUserInitialInput() == -1)
                stopApplication = true;
        }
    }
}
