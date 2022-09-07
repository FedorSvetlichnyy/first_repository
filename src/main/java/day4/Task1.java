package day4;

import java.util.Random;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите длинну массива: ");
        int line = scanner.nextInt();

        int[] array = new int[line];
        for(int i = 0; i<array.length; i++){
            Random random = new Random();
            array[i] = random.nextInt(11);
            }
        System.out.print("Сгенерирован случайный массив чисел: ");
        for(int j:array){
                System.out.print(j + " ");
            }
        System.out.println();
        System.out.print("Длинна массива: " + line);

        int amount = 0;
        for(int i = 0; i < array.length; i++) {
            if(array[i] > 8) amount++;
        }
        System.out.println();
        System.out.print("Количество чисел больше 8: " + amount);

        int amount1 = 0;
        for(int i = 0; i < array.length; i++) {
            if(array[i] == 1) amount1++;
        }
        System.out.println();
        System.out.print("Количество чисел равных 1: " + amount1);

        int amount2 = 0;
        for(int i = 0; i < array.length; i++) {
            if(array[i]%2==0) amount2++;
        }
        System.out.println();
        System.out.print("Количество четных чисел: " + amount2);

        int amount3 = 0;
        for(int i = 0; i < array.length; i++) {
            if(array[i]%2!=0) amount3++;
        }
        System.out.println();
        System.out.print("Количество нечетных чисел: " + amount3);

        int sum = 0;
        for (int i:array) {
            sum = sum + i;
        }
        System.out.println();
        System.out.println("Сумма всех элементов массива: " + sum);

    }
}
