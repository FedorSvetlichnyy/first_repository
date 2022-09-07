package day3;

import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {

        for (int i = 0; i<=4; i++){
            Scanner scanner = new Scanner(System.in);
            System.out.println("¬ведите числитель: ");
            double numerator = scanner.nextDouble();
            System.out.println("¬ведите знаменатель: ");
            double denominator = scanner.nextDouble();

            if(denominator == 0){
                System.out.println("ƒеление на 0");
                continue;
            }
            System.out.println(numerator / denominator);

        }

    }
}
