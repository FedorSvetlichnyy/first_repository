package day3;

import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("�������� �����, � � ������ ������: ");
            String city = scanner.nextLine();
            switch (city) {
                case "������":
                case "�����������":
                case "������":
                    System.out.println("������");
                    break;
                case "���":
                case "�����":
                case "�����":
                    System.out.println("������");
                    break;
                case "���������":
                case "���������":
                case "������":
                    System.out.println("������");
                    break;
                case "������":
                case "������":
                case "ʸ���":
                    System.out.println("��������");
                    break;
                case "Stop":
                    break;
                default:
                    System.out.println("����������� ������");

            }
            if(city.equals("Stop"))
                break;
        }


    }
}
