package day3;

import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {

        while (true) {

            Scanner scanner = new Scanner(System.in);
            System.out.println("������� ���������: ");
            double numerator = scanner.nextDouble();
            System.out.println("������� �����������: ");
            double denominator = scanner.nextDouble();

            if(denominator == 0){
                break;
            }

            System.out.println(numerator / denominator);

        }

    }
}
