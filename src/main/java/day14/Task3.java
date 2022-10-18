package day14;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        File file = new File("people2.txt");
        System.out.println(parseFileToObjList(file).toString());
    }

    public static List<Person> parseFileToObjList(File file) {

        try {
            Scanner scanner = new Scanner(file);
            List<Person> list = new ArrayList<>();
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] x = line.split(" ");
                Person person = new Person(x[0], Integer.parseInt(x[1]));
                if (Integer.parseInt(x[1]) < 0) throw new IOException("Invalid input file");
                list.add(person);
            }
            scanner.close();
            return list;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            System.exit(0);
        }
        return null;
    }
}

class Person {
    private int age;
    private String name;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String toString() {
        return "name='" + this.name + "', year=" + this.age;
    }
}
