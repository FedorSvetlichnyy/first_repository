package day16;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        File file = new File("day16task1.txt");
        printResult(file);

    }

    public static void printResult(File file) {
        try {
            Scanner scanner = new Scanner(file);

            String line = scanner.nextLine();
            String[] numbersString = line.split(" ");
            int[] numbers = new int[7];
            int counters = 0;

            for (String number : numbersString) {
                numbers[counters++] = Integer.parseInt(number);
            }
            scanner.close();
            int sum = 0;
            for (int i = 0; i < numbers.length; i++) {
                sum = sum + numbers[i];
            }
            double average = (double) sum / numbers.length;
            String str = String.format("%.3f", average);
            System.out.println(average + " --> " + str);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}

