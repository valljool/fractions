package pro1;

import java.util.Scanner;

public class InteractiveDoubleParsing {
    static Scanner entry = new Scanner(System.in);
    public static void main(String[] args) {
        while(true) {
            double d = inputHandler();
            System.out.printf("Zadal jste číslo %f \n", d);
        }
    }

    public static double inputHandler() {
        System.out.println("Zadejte číslo: ");
        return checkIfDouble();
    }

    private static double checkIfDouble(){
        while(!entry.hasNextDouble()){
            Utils.generateLine();
            System.out.printf("Zadal jste neplatný řetězec %s  \n", entry.next());
            System.out.println("Zadejte číslo: ");
        }
        Utils.generateLine();
        return entry.nextDouble();
    }


}

