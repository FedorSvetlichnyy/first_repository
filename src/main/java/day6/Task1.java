package day6;

public class Task1 {
    public static void main(String[] args) {

        Car car1 = new Car();
        car1.setModel("����");
        car1.setColor("�������");
        car1.setYear(1978);
        car1.info();
        int years = car1.yearDifference(1956);
        System.out.println("������� ����� ���������� ����� � ����� ������� ������������� �������� ���������� " + years + " ���� (���).");

        Motorbike bike = new Motorbike("���", "������", 1990);
        bike.info();
        int years2 = bike.yearDifference(1985);
        System.out.println("������� ����� ���������� ����� � ����� ������� ������������� �������� ���������� " + years2 + " ���� (���).");


    }
}
