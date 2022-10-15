package day14;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) throws IOException {
        File file = new File("people.txt");
        System.out.println(parseFileToObjList(file).toString());
    }

    public static List<Person> parseFileToObjList(File file) throws IOException {
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден / File not found");
        }
        try {
            List<Person> list = new ArrayList<>();
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] x = line.split(" ");
                Person person = new Person(x[0], Integer.parseInt(x[1]));
                if (Integer.parseInt(x[1]) < 0) {
                    throw new IOException();
                }
                list.add(person);
            }
            scanner.close();
            return list;
        } catch (IOException e) {
            System.out.println("Некорректный входной файл / Invalid input file");
            System.exit(0);
        }
        return null;
    }
}
class Person{
    private int age;
    private String name;

    public Person (String name, int age){
        this.name = name;
        this.age = age;
    }
    public String toString() {
        return "name='" + this.name + "', year=" + this.age;
    }
}
