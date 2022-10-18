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
        getNumbersCount(file); //check

        try {
            Scanner scanner = new Scanner(file);
            String line = scanner.nextLine();
            String[] numbersString = line.split(" ");
            int[] numbers = new int[10];
            int counters = 0;

            for (String number : numbersString) {
                numbers[counters++] = Integer.parseInt(number);
            }
            scanner.close();
            int sum = 0;
            for (int i = 0; i < numbers.length; i++) {
                sum = sum + numbers[i];
            }
            System.out.println("Sum of all numbers in file: " + sum);

        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден / File not found");
        }
    }

    public static void getNumbersCount(File file) {
        try {
            Scanner scanner = new Scanner(file);
            int numbersCount = 0;
            while (scanner.hasNextLine()) {
                String[] array = scanner.nextLine().split(" ");
                numbersCount = numbersCount + array.length;
            }
            scanner.close();
            if (numbersCount != 10) throw new IOException("Invalid input file");
        } catch (IOException e) {
            System.out.println(e.getMessage());
            System.exit(0);
        }
    }
}
