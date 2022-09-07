package day3;

import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {

        while (true) {

            Scanner scanner = new Scanner(System.in);
            System.out.println("¬ведите числитель: ");
            double numerator = scanner.nextDouble();
            System.out.println("¬ведите знаменатель: ");
            double denominator = scanner.nextDouble();

            if(denominator == 0){
                break;
            }

            System.out.println(numerator / denominator);

        }

    }
}
