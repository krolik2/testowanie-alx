package com.example;

import java.util.Scanner;

public class TriangleArea {

    static boolean inputLengthEquals3(String[] input) {
        return input.length == 3;
    }

    static boolean inputIsNumber(String[] input) {
        try {
            for (String i : input) {
                Integer.parseInt(i);
            }
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    static boolean canMakeTriangle(int a, int b, int c) {
        return a + b > c && b + c > a && c + a > b;
    }

    static double calculateTriangleArea(int a, int b, int c) {
        double p = (a + b + c) / 2.0;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Podaj dlugosc bokow trojkata, oddzielonych spacja:");
            String input = sc.nextLine();
            String[] triangleDimensions = input.split("\\s+");

            if (!inputLengthEquals3(triangleDimensions) || !inputIsNumber(triangleDimensions)) {
                System.out.println("Nieprawidlowe dane wejsciowe");
                return;
            }

            int a = Integer.parseInt(triangleDimensions[0]);
            int b = Integer.parseInt(triangleDimensions[1]);
            int c = Integer.parseInt(triangleDimensions[2]);

            if (!canMakeTriangle(a, b, c)) {
                System.out.println("Nieprawidlowe wymiary trojkata");
                return;
            }

            double triangleArea = calculateTriangleArea(a, b, c);
            System.out.println("Pole powierzchni trojkata wynosi " + triangleArea);

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}