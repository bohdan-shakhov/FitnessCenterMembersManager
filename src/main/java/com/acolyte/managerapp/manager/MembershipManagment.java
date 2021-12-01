package com.acolyte.managerapp.manager;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MembershipManagment {
    private final Scanner SCANNER = new Scanner(System.in);

    private int getIntInput() {
        int choise = 0;

        while (choise == 0) {
            try {
                choise = SCANNER.nextInt();
                if (choise == 0) {
                    throw new InputMismatchException();
                }
                SCANNER.nextLine();
            } catch (InputMismatchException e) {
                System.err.println("INVALID INPUT. Please try again: ");
            }
        }
        return choise;
    }

    private void printClubOptions() {
        System.out.println("Club Mercury");
        System.out.println("Club Neptune");
        System.out.println("Club Jupiter");
        System.out.println("Multi Clubs");
    }


}
