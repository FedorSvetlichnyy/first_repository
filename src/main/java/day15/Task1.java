package day15;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {

        try {
            File fileBegin = new File("g:\\JAVA\\shoes.csv");
            File fileEnd = new File("g:\\JAVA\\missing_shoes.txt");
            Scanner scanner = new Scanner(fileBegin);
            PrintWriter pw = new PrintWriter(fileEnd);
            /*String cheсk = "Название;Размер;Кол-во";
            if (scanner.nextLine().equals(cheсk)) {
                System.out.println("Correct input file");
            } else {
                System.out.println("Invalid input file");
                return;
            }*/
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] missing_shoes = line.split(";");
                if (missing_shoes.length > 3) {
                    System.out.println("Invalid input file");
                    return;
                } else if (missing_shoes.length < 3) {
                    System.out.println("Invalid input file");
                    return;
                } else {
                   if(Integer.parseInt(missing_shoes[2]) == 0){
                    pw.println(line);
                }
            }
        }
        scanner.close();
        pw.close();
    } catch(FileNotFoundException e) {
        System.out.println(e.getMessage());
    }
}
}
