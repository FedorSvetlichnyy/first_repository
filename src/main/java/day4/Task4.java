package day4;

import java.util.Random;
import java.util.Arrays;

public class Task4 {
    public static void main(String[] args) {
        int[] array = new int[100];
        for(int i = 0; i<array.length; i++){
            Random random = new Random();
            array[i] = random.nextInt(10000);
        }
        System.out.println();
        System.out.print("Массив чисел: ");
        /*for(int j:array){
            System.out.print(j + " ");
        }*/
        System.out.println(Arrays.toString(array));

        //int[] array = {0, 1, 2, 3, 4, 5};
        int[] arraySum = new int[array.length-2];

        for (int i = 0, j = 0; i < array.length - 2; i = i + 1 - 2, j++) {
            //if (array6[i] == 4) {
            arraySum[j] = array[i] + array[++i] + array[++i];
        }

        //System.out.println(Arrays.toString(arraySum));

        int arrayMax=0;
        for (int k:arraySum) {
            if (k > arrayMax)
                arrayMax = k;
            continue;
        }
        System.out.println(arrayMax);

        for (int v = 0; v < arraySum.length; v++) {
            if (arraySum[v] == arrayMax) {
                System.out.println(v);
                break;
            }
        }



    }


}
