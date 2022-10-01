package day12;

import java.util.ArrayList;
import java.util.List;

public class Task2 {
    public static void main(String[] args) {
        List<Integer> arrayList = new ArrayList<>();
        for(int i = 0; i<30; i++){
            if(i%2 == 0){ //если остаток от деления = 0, что добавляем это число в массив, значит оно четное
                arrayList.add(i);
            }
        }
        //System.out.println(arrayList);
        minMax(300, 350, arrayList);
        System.out.println(arrayList);
    }

    private static void minMax(int min, int max, List list) { //метод, который принимает числа от, до, и ссылку на список
        for (int i = min; i < max; i++) {
            if (i % 2 == 0) { //если остаток от деления = 0, что добавляем это число в массив, значит оно четное
                list.add(i);
            }
        }
    }
}

