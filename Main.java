package machine;
import java.util.Scanner;

public class Main {

    private static int waterLevel = 400;
    private static int milkLevel = 540;
    private static int beansLevel = 120;
    private static int cupsLevel = 9;
    private static int moneyLevel = 550;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Write action (buy, fill, take, remaining, exit):");
        String option = scanner.next();
        while (!option.equalsIgnoreCase("exit")) {
            switch (option) {
                case "buy":
                    System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
                    String choice = scanner.next();
                    if (choice.equalsIgnoreCase("1")) {
                        if (checkResources(1)) {
                            waterLevel -= 250;
                            beansLevel -= 16;
                            cupsLevel--;
                            moneyLevel += 4;
                            break;
                        } else {
                            break;
                        }
                    }
                    else if (choice.equalsIgnoreCase("2")) {
                        if (checkResources(2)) {
                            waterLevel -= 350;
                            milkLevel -= 75;
                            beansLevel -= 20;
                            cupsLevel--;
                            moneyLevel += 7;
                            break;
                        } else {
                            break;
                        }
                    }
                    else if (choice.equalsIgnoreCase("3")) {
                        if (checkResources(3)) {
                            waterLevel -= 200;
                            milkLevel -= 100;
                            beansLevel -= 12;
                            cupsLevel--;
                            moneyLevel += 6;
                            break;
                        } else {
                            break;
                        }
                    }
                    if (choice.equalsIgnoreCase("back")) {
                        break;
                    }
                    break;
                case "fill":
                    System.out.println("Write how many ml of water do you want to add:");
                    int addWater = scanner.nextInt();
                    waterLevel += addWater;
                    System.out.println("Write how many ml of milk do you want to add:");
                    int addMilk = scanner.nextInt();
                    milkLevel += addMilk;
                    System.out.println("Write how many grams of coffee beans do you want to add:");
                    int addBeans = scanner.nextInt();
                    beansLevel += addBeans;
                    System.out.println("Write how many disposable cups of coffee do you want to add:");
                    int addCups = scanner.nextInt();
                    cupsLevel += addCups;
                    break;
                case "take":
                    showMoney();
                    break;
                case "remaining":
                    showBalance();
                    break;
            }
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            option = scanner.next();
        }
    }
    private static void showMoney() {
        System.out.println("I gave you $" + moneyLevel);
        moneyLevel = 0;
    }
    private static void showBalance() {
        System.out.println("The coffee machine has:");
        System.out.println(waterLevel + " of water");
        System.out.println(milkLevel + " of milk");
        System.out.println(beansLevel + " of coffee beans");
        System.out.println(cupsLevel + " of disposable cups");
        System.out.println(moneyLevel + " of money");
    }
    private static boolean checkResources(int choise) {
        boolean enoughResources = false;
        switch (choise) {
            case 1:
                if(waterLevel < 250) {
                    System.out.println("Sorry, not enough water!");
                    break;
                } else if (beansLevel < 16) {
                    System.out.println("Sorry, not enough coffee beans!");
                    break;
                } else if (cupsLevel < 1) {
                    System.out.println("Sorry, not enough disposable cups!");
                    break;
                } else {
                    enoughResources = true;
                    System.out.println("I have enough resources, making you a coffee!");
                    break;
                }
            case 2:
                if(waterLevel < 350) {
                    System.out.println("Sorry, not enough water!");
                    break;
                } else if (milkLevel < 75) {
                    System.out.println("Sorry, not enough milk!");
                    break;
                } else if (beansLevel < 20) {
                    System.out.println("Sorry, not enough coffee beans!");
                    break;
                } else if (cupsLevel < 1) {
                    System.out.println("Sorry, not enough disposable cups!");
                    break;
                } else {
                    enoughResources = true;
                    System.out.println("I have enough resources, making you a coffee!");
                    break;
                }
            case 3:
                if(waterLevel < 200) {
                    System.out.println("Sorry, not enough water!");
                    break;
                } else if (milkLevel < 100) {
                    System.out.println("Sorry, not enough milk!");
                    break;
                } else if (beansLevel < 12) {
                    System.out.println("Sorry, not enough coffee beans!");
                    break;
                } else if (cupsLevel < 1) {
                    System.out.println("Sorry, not enough disposable cups!");
                    break;
                } else {
                    enoughResources = true;
                    System.out.println("I have enough resources, making you a coffee!");
                    break;
                }
        }
        return enoughResources;
    }
}
