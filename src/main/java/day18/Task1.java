package day18;

public class Task1 {
    public static void main(String[] args) {
        int[] numbers = {1, 10, 1241, 50402, -50, 249, 10215, 665, 2295, 7, 311};
        //int arrayLength = numbers.length-1;
        System.out.println(recursionSum(numbers, numbers.length - 1)); // 65346
    }
    public static int recursionSum(int[] array, int i){
        if(i == 0)
            return array[0];
        return array[i] + recursionSum(array, i - 1);
    }
}
