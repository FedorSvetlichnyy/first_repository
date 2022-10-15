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
        try {
            getNegativeNumbers(file);
        } catch (IOException e) {
            System.out.println("Некорректный входной файл / Invalid input file");
            System.exit(0);
        }

        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден / File not found");
        }

        List<String> list = new ArrayList<String>();
        while (scanner.hasNextLine()){
            list.add(scanner.nextLine());
        }
        //System.out.println(list);
        scanner.close();
        return list;
    }

    public static void getNegativeNumbers(File file) throws IOException {
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден / File not found");
        }
        while (scanner.hasNextLine()){
            String line = scanner.nextLine();
            if(line.contains(" -")){
                throw new IOException();
            }
        }
        scanner.close();

    }
}
