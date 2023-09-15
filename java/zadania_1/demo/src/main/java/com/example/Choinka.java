package com.example;

import java.util.Scanner;

public class Choinka {

    static void printer() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Podaj liczbe calkowita");
        Integer input = sc.nextInt();

        if (input > 0) {
            for (int i = 1; i <= input; i++) {

                for (int j = 0; j < input - i; j++) {
                    System.out.print(" ");
                }

                for (int k = 0; k < 2 * i - 1; k++) {
                    System.out.print("*");
                }

                System.out.println();
            }

            sc.close();
        }

    }

    public static void main(String[] args) {
        printer();

    }

}
