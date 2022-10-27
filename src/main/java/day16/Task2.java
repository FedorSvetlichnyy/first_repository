package day16;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) throws FileNotFoundException {
        File file1 = new File("file1.txt");
        File file2 = new File("file2.txt");
        PrintWriter pw1 = new PrintWriter(file1);
        for (int i = 0; i < 1000; i++) {
            int random = (int) (Math.random() * 101);
            pw1.print(random + " ");
        }
        pw1.close();

        Scanner scanner = new Scanner(file1);
        String line = scanner.nextLine();
        String[] numbersString = line.split(" ");
        int[] numbers = new int[1000];
        int counters = 0;
        for (String number : numbersString) {
            numbers[counters++] = Integer.parseInt(number);
        }
        scanner.close();

        double[] arraySum = new double[50];
        //перебирай массив, суммируй каждый элемент и подсчитывай кол-во уже пройденных элементов.
        // Как только кол-во стало равно 20, записывай сумму в файл, обнуляй сумму.
        // Следующая итерация продолжит суммировать элементы, но прибавляться уже будет к нулю (а не к сумме прошлых двадцати)
        int sum = 0;
        for (int i = 0, j = 0; i < numbers.length; i++) {
            sum = sum + numbers[i];
            if((i % 20) == 0){
                arraySum[j] = (double) (sum) / 20;
                j++;
                sum = 0;
            }
            /*arraySum[j] = (double) (numbers[i] + numbers[++i] + numbers[++i] + numbers[++i] + numbers[++i] +
                    numbers[++i] + numbers[++i] + numbers[++i] + numbers[++i] + numbers[++i] +
                    numbers[++i] + numbers[++i] + numbers[++i] + numbers[++i] + numbers[++i] +
                    numbers[++i] + numbers[++i] + numbers[++i] + numbers[++i] + numbers[++i]) / 20;*/

        }

        PrintWriter pw2 = new PrintWriter(file2);
        for (double number : arraySum) {
            pw2.print(number + " ");
        }
        pw2.close();

        printResult(file2);

    }

    public static void printResult(File file) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        String line = scanner.nextLine();
        String[] numbersString = line.split(" ");
        double[] numbers = new double[50];
        int counters = 0;
        for (String number : numbersString) {
            numbers[counters++] = Double.parseDouble(number);
        }
        int sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            sum = (int) ((int) sum + numbers[i]);
        }
        //System.out.println(Arrays.toString(numbers));
        System.out.println(sum);
        scanner.close();
    }
}

