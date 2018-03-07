package tues.funwithfunctions;

import java.util.Scanner;

/**
 *
 * @author john
 */
public class TuesFunWIthFunctions {

    public static void printGreeting(String name, String lastName) {
        System.out.println("Hello " + name + " " + lastName + "!");
    }

    public static void printGreeting(String name, int age) {
        System.out.println("Hello " + name + " you are " + age + " years old!");
    }

    public static int doubleAmount(int value) {
        value = value * 2;
        return value;
    }

    public static int getRandomNumber() {
        return (int) (Math.random() * 100.0);
    }

    public static String[] separateTemperatureValueAndUnit(String userInput) {
        return userInput.split(" ");
    }

    public static int getTemperatureValue(String userInput) {
        // ex userInput: 70 F
        return Integer.parseInt(separateTemperatureValueAndUnit(userInput)[0]);
    }

    public static String getTemperatureUnit(String userInput) {
        return separateTemperatureValueAndUnit(userInput)[1];
    }

    public static boolean isCelsius(String userInput) {
        return getTemperatureUnit(userInput).equalsIgnoreCase("C");
    }

    public static boolean isTemperatureValid(int temperatureValue, boolean isCelsius) {
        if (isCelsius) {
            return temperatureValue >= -40 && temperatureValue <= 40;
        } else {
            return temperatureValue >= -40 && temperatureValue <= 95;
        }
    }

    public static String getUserInput() {
        Scanner stdin = new Scanner(System.in);
        String userInput;
        boolean isValid = false;

        do {
            System.out.println("Please enter a temperature (e.g. 70 f): ");
            userInput = stdin.nextLine();

            if (isTemperatureValid(
                    getTemperatureValue(userInput),
                    isCelsius(userInput))) {
                isValid = true;
            } else {
                System.out.println("Invalid temperature, please try again.");
            }
        } while (!isValid);

        return userInput;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String userInput = getUserInput();
        int temperature = getTemperatureValue(userInput);
        boolean isCelsius = isCelsius(userInput);

        System.out.println(
                "The temperature is: "
                + temperature
                + " and it isCelsius is: "
                + isCelsius
        );
//        printGreeting("John", "Haley");
//        printGreeting("John", 37);
//        
//        int originalValue = 2;
//        int doubledValue = doubleAmount(originalValue);
//        
//        System.out.println(originalValue);
//        System.out.println(doubledValue);
//        
//        System.out.println(getRandomNumber());
//        System.out.println(getRandomNumber());
    }

}
