package day4;

import java.util.Random;
import java.util.Arrays;

public class Task3 {
    public static void main(String[] args) {
        int[][] array = new int[12][8];
        for(int i = 0; i<12; i++)
            for(int j = 0; j<8; j++){
            Random random = new Random();
            array[i][j] = random.nextInt(50);

        }

        System.out.print("Сгенерированный массив чисел: ");
        System.out.println();

        for(int i = 0; i<array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }

        int[] newArray = new int[array.length];
        int i;
        for(i = 0; i<array.length; i++) {
            for (int j: array[i]) {
                newArray[i] = newArray[i] + j;
            }
            //System.out.println("Сумма всех элементов строки " + i + ": " + newArray[i]);

        }
        int arrayMax=0;
        for (int k:newArray) {
            if (k > arrayMax)
                arrayMax = k;
        }

        int index = 0;
        for(int l=0; i<newArray.length; l++){
                if(newArray[l] == arrayMax){
                    index = l;
                }
        }
        //System.out.println(Arrays.toString(newArray));
        for (int v = 0; v < newArray.length; v++) {
            if (newArray[v] == arrayMax) {
                System.out.println("Ответ: " + v + " (индекс строки, сумма чисел в которой максимальна).");
                break;
            }
        }

    }
}
