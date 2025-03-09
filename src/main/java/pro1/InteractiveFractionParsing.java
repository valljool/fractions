package pro1;

import java.util.Scanner;

public class InteractiveFractionParsing {
    static Scanner entry = new Scanner(System.in);

    public static void main(String[] args) {
        while(true) {
            inputHandler();
        }
    }


    private static void inputHandler() {
        checkIfFraction();
    }


/*
    private static void checkIfFraction(){
        Utils.generateLine();
        System.out.println("Zadejte zlomek: ");
        String input = entry.nextLine();
        try {
            System.out.printf("Zadal jste zlomek: %s  \n", Fraction.parse(input));
        }catch(Exception e){
            System.out.printf("Zadal jste neplatný řetězec %s  \n", input);
            checkIfFraction();
        }
    }*/

    private static void checkIfFraction(){
        boolean end = false;
        while(!end) {
            Utils.generateLine();
            System.out.println("Zadejte zlomek: ");
            String input = entry.nextLine();
            try {
                System.out.printf("Zadal jste zlomek: %s  \n", Fraction.parse(input));
                end = true;
            } catch (Exception e) {
                System.out.printf("Zadal jste neplatný řetězec %s  \n", input);
            }
        }
    }


}
