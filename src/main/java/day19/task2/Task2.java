package day19.task2;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Neil Alishev
 */
public class Task2 {
    public static void main(String[] args) {

        Map<Integer, Point> map = getHashMapFromTextFile();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите координаты квадрата (x1, y1, x2, y2): ");

        int x1;
        do {
            System.out.println("Введите координаты точки x1 от 0 до 99");
            while (!scanner.hasNextInt()) {
                System.out.println("Это не число!");
                scanner.next();
            }
            x1 = scanner.nextInt();
        } while (x1 < 0 | x1 > 99);

        int y1;
        do {
            System.out.println("Введите координаты точки y1 от 0 до 99");
            while (!scanner.hasNextInt()) {
                System.out.println("Это не число!");
                scanner.next();
            }
            y1 = scanner.nextInt();
        } while (y1 < 0 | y1 > 99);

        int x2;
        do {
            System.out.println("Введите координаты точки x2 от 0 до 99");
            while (!scanner.hasNextInt()) {
                System.out.println("Это не число!");
                scanner.next();
            }
            x2 = scanner.nextInt();
        } while (x2 < 0 | x2 > 99);

        int y2;
        do {
            System.out.println("Введите координаты точки y2 от 0 до 99");
            while (!scanner.hasNextInt()) {
                System.out.println("Это не число!");
                scanner.next();
            }
            y2 = scanner.nextInt();
        } while (y2 < 0 | y2 > 99);

        scanner.close();

        int carsVolume = 0;
        for (Map.Entry<Integer, Point> enrty : map.entrySet()) {
            if (x1 < enrty.getValue().getX() & x2 > enrty.getValue().getX() & y1 > enrty.getValue().getY() & y2 < enrty.getValue().getY()) {
                carsVolume++;
                System.out.println("В заданном квадрате машина с идентификатором: " + enrty.getKey());
            }
            if (x1 > enrty.getValue().getX() & x2 < enrty.getValue().getX() & y1 < enrty.getValue().getY() & y2 > enrty.getValue().getY()) {
                carsVolume++;
                System.out.println("В заданном квадрате машина с идентификатором: " + enrty.getKey());
            }
            if (x1 < enrty.getValue().getX() & x2 > enrty.getValue().getX() & y1 < enrty.getValue().getY() & y2 > enrty.getValue().getY()) {
                carsVolume++;
                System.out.println("В заданном квадрате машина с идентификатором: " + enrty.getKey());
            }
            if (x1 > enrty.getValue().getX() & x2 < enrty.getValue().getX() & y1 > enrty.getValue().getY() & y2 < enrty.getValue().getY()) {
                carsVolume++;
                System.out.println("В заданном квадрате машина с идентификатором: " + enrty.getKey());
            }
        }
        System.out.println("В заданном квадрате " + carsVolume + " машин(-а, -ы).");

    }

    public static Map<Integer, Point> getHashMapFromTextFile() {

        Map<Integer, Point> mapFileContents = new HashMap<Integer, Point>();
        BufferedReader br = null;

        try {
            File file = new File("src\\main\\resources\\taxi_cars.txt");

            br = new BufferedReader(new FileReader(file));
            String line = null;
            while ((line = br.readLine()) != null) {

                String[] id_x_y = line.split(" ");
                Integer key = Integer.parseInt(id_x_y[0].trim());
                Integer x = Integer.parseInt(id_x_y[1].trim());
                Integer y = Integer.parseInt(id_x_y[2].trim());
                Point point = new Point(x, y);
                mapFileContents.put(key, point);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (Exception e) {
                }
            }
        }

        return mapFileContents;
    }
}
