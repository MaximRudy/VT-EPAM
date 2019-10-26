package com.epam.rudy.util;

import java.util.Objects;
import java.util.Scanner;

import com.epam.rudy.entity.VehicleType;

public final class ConsoleUtil {

    public static void printAppWelcomeMessage() {
        System.out.println("##########################################################");
        System.out.println("Welcome to the small \'rent-a-car\' admin application.");
        System.out.println("##########################################################\n");
        System.out.println("Please choose one of the following options: \n");
        System.out.println("0 - To show all present vehicles");
        System.out.println("1 - To add a new vehicle");
        System.out.println("2 - To find a specific vehicle");
        System.out.println("3 - To update a specific vehicle");
        System.out.println("4 - To delete a specific vehicles\n");
        System.out.println("To quite the app please enter \':wq\'. ");
        System.out.println("##########################################################");
    }

    public static int processUserInitialInput() {
        int input = -1;
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            if ((sc.hasNextInt()
                 && checkIntNumberRange4InitialChoice(input = sc.nextInt()))
                     || checkExitOption(sc.next()))
                return input;
            else {
                System.out.println("Please enter a valid integer number from range 1-4 " +
                    "or enter \':wq\' to quite");
                continue;
            }
        }
        return input;
    }

    public static SearchDisplayCriteria processUserInput4Display() {
        int input = -1;
        SearchDisplayCriteria criteria = null;
        System.out.println("Please choose the option to use during display sorting: \n");
        System.out.println("0 - By vehicle id (by default)");
        System.out.println("1 - By vehicle model");
        System.out.println("2 - By vehicle type");
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            if ((sc.hasNextInt() && checkIntNumberRange4Display(input = sc.nextInt())))
                    criteria = defineDisplayCriteria(input);
            else if (checkExitOption(sc.next()))
                criteria = new SearchDisplayCriteria.SearchCriteriaBuilder().build();
            else {
                System.out.println("Please enter a valid integer number from range 1-4 " +
                    "or enter \':wq\' to quite");
                continue;
            }
        }
        return criteria;
    }

    private static boolean checkIntNumberRange4InitialChoice(int input) {
        return (input >= 0 && input <= 4) ? true : false;
    }

    private static boolean checkIntNumberRange4Display(int input) {
        return (input >= 0 && input <= 2) ? true : false;
    }

    private static boolean checkExitOption(String input) {
        return Objects.equals(":wq", input);
    }

    private static SearchDisplayCriteria defineDisplayCriteria(int input) {
        SearchDisplayCriteria.SearchCriteriaBuilder criteriaBuilder =
                              new SearchDisplayCriteria.SearchCriteriaBuilder();
        switch (input) {
            case 1:
                criteriaBuilder.withVehicleId(processUserInput4StringParameter("id"));
                break;
            case 2:
                criteriaBuilder.withVehicleModel(processUserInput4StringParameter("model"));
                break;
            case 3:
                criteriaBuilder.withVehicleType(processUserInput4VehicleType());
                break;
            default:
                break;
        }
        return criteriaBuilder.build();
    }

    private static String processUserInput4StringParameter(String parameterName) {
        Scanner sc = new Scanner(System.in);
        System.out.printf("Please enter vehicle %s: ", parameterName);
        while(sc.hasNext()) {
            return sc.next();
        }
        return "";
    }

    private static VehicleType processUserInput4VehicleType() {
        // Mock
        return VehicleType.FUEL_CAR;
    }
}
