package day12;

import java.util.ArrayList;
import java.util.List;

public class Task2 {
    public static void main(String[] args) {
        List<Integer> arrayList = new ArrayList<>();
        for(int i = 0; i<30; i++){
            if(i%2 == 0){ //���� ������� �� ������� = 0, ��� ��������� ��� ����� � ������, ������ ��� ������
                arrayList.add(i);
            }
        }
        //System.out.println(arrayList);
        minMax(300, 350, arrayList);
        System.out.println(arrayList);
    }

    private static void minMax(int min, int max, List list) { //�����, ������� ��������� ����� ��, ��, � ������ �� ������
        for (int i = min; i < max; i++) {
            if (i % 2 == 0) { //���� ������� �� ������� = 0, ��� ��������� ��� ����� � ������, ������ ��� ������
                list.add(i);
            }
        }
    }
}

