package day4;

import java.util.Random;

public class Task2 {
    public static void main(String[] args) {
        int[] array = new int[100];
        for(int i = 0; i<array.length; i++){
            Random random = new Random();
            array[i] = random.nextInt(10000);
        }
        System.out.println();
        System.out.print("������ �����: ");
        for(int j:array){
            System.out.print(j + " ");
        }

        int arrayMax=0;
        for (int i:array) {
            if (i > arrayMax)
                arrayMax = i;
        }
        System.out.println();
        System.out.print("���������� ������� �������: " + arrayMax);

        int arrayMin=10000;
        for (int i:array) {
            if (i < arrayMin)
                arrayMin = i;
        }
        System.out.println();
        System.out.print("���������� ������� �������: " + arrayMin);

        int amount = 0;
        for (int i:array) {
            if(i%10==0)
                amount++;
        }
        System.out.println();
        System.out.print("���������� ��������� �������, �������������� �� 0: " + amount);

        int sum = 0;
        for (int i:array) {
            if(i%10==0)
                sum += i;
        }
        System.out.println();
        System.out.println("����� ��������� �������, �������������� �� 0: " + sum);


    }
}
