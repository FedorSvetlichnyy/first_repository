package day14;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("people.txt");
        //parseFileToStringList(file);
        System.out.println(parseFileToStringList(file));

    }

    public static List<String> parseFileToStringList(File file) {
        getNegativeNumbers(file);

        try {
            Scanner scanner = new Scanner(file);
            List<String> list = new ArrayList<String>();
            while (scanner.hasNextLine()) {
                list.add(scanner.nextLine());
            }
            scanner.close();
            return list;
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден / File not found");
        }
        return null;
    }

    public static void getNegativeNumbers(File file) {
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] x = line.split(" ");
                if (Integer.parseInt(x[1]) < 0) throw new IOException("Invalid input file");
            }
            scanner.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
            System.exit(0);
        }

    }
}
