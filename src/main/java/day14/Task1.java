package day14;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        File file = new File("day14task1.txt");
        printSumDigits(file);
    }
    public static void printSumDigits(File file) {
        try {
            getNumbersCount(file);
        } catch (IOException e) {
            System.out.println("Некорректный входной файл / Invalid input file");
            System.exit(0);
        }

        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден / File not found");;
        }

        String line = scanner.nextLine();
        String[] numbersString = line.split(" ");
        int[] numbers = new int[10];
        int counters = 0;

        for (String number: numbersString) {
            numbers[counters++] = Integer.parseInt(number);
            /*try{numbers[counters++] = Integer.parseInt(number);}
            catch (ArrayIndexOutOfBoundsException e){
                System.out.println("Некорректный входной файл");
            }*/
        }
        scanner.close();
        //sum of array
        int sum = 0;
        for(int i = 0; i<numbers.length; i++){
            sum = sum + numbers[i];
        }
        System.out.println("Sum of all numbers in file: " + sum);

    }
    public static void getNumbersCount(File file) throws IOException {
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден / File not found");;
        }
        int numbersCount = 0;
        while (scanner.hasNextLine()) {
            String[] array = scanner.nextLine().split(" ");
            numbersCount = numbersCount + array.length;
        }
        scanner.close();
        if(numbersCount != 10){
            throw new IOException();
        }
    }
}
