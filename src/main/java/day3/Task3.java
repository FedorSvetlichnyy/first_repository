package day3;

import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {

        for (int i = 0; i<=4; i++){
            Scanner scanner = new Scanner(System.in);
            System.out.println("������� ���������: ");
            double numerator = scanner.nextDouble();
            System.out.println("������� �����������: ");
            double denominator = scanner.nextDouble();

            if(denominator == 0){
                System.out.println("������� �� 0");
                continue;
            }
            System.out.println(numerator / denominator);

        }

    }
}
