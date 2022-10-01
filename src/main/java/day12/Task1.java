package day12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task1 {
    public static void main(String[] args) {
        List<String> auto = new ArrayList<>();
        auto.add("BMW");
        auto.add("Hyundai");
        auto.add("VAZ");
        auto.add("UAZ");
        auto.add("GAZ");
        System.out.println(auto);
        auto.add(2,"Audi");
        System.out.println(auto);
        auto.remove(0);
        System.out.println(auto);
        System.out.println(); //просто пустая строчка для отделения

        // с помощью метода Arrays.asList() для создания нового списка с начальными элементами
        List<String> auto2 = new ArrayList<>(Arrays.asList("BMW", "Hyundai", "VAZ", "UAZ", "GAZ"));
        System.out.println(auto2);

    }
}
