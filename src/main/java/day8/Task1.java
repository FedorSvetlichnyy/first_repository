package day8;

public class Task1 {
    public static void main(String[] args) {
        //1. числа через пробел  - цикл
        long startTime = System.currentTimeMillis();
        for(int i = 0; i<20001; i++){
            System.out.print(i + " ");
        }
        System.out.println();
        long stopTime = System.currentTimeMillis();
        //System.out.println("Длительность работы 1 программы, в мс.: " + (stopTime-startTime));

        //2. числа через пробел  - String
        long startTime2 = System.currentTimeMillis();
        for(int i = 0; i<20001; i++){
            String string1 = String.format("%s ",i);
            System.out.print(string1);
        }
        System.out.println();
        long stopTime2 = System.currentTimeMillis();
        //System.out.println("Длительность работы 2 программы, в мс.: " + (stopTime2-startTime2));

        //3. числа через пробел  - StringBuilder
        long startTime3 = System.currentTimeMillis();
        for(int i = 0; i<20001; i++){
            StringBuilder sb = new StringBuilder(i + " ");
            System.out.print(sb);
        }
        System.out.println();
        long stopTime3 = System.currentTimeMillis();
        System.out.println("Длительность работы 1 программы, в мс.: " + (stopTime-startTime));
        System.out.println("Длительность работы 2 программы, в мс.: " + (stopTime2-startTime2));
        System.out.println("Длительность работы 3 программы, в мс.: " + (stopTime3-startTime3));

    }
}
