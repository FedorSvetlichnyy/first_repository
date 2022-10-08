package day12.task4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task4 {
    public static void main(String[] args) {
        MusicBand musicBand1 = new MusicBand("BalckYedPeace", 2001, Arrays.asList("Shakira", "Mattel"));
        MusicBand musicBand2 = new MusicBand("Eminem", 1995, Arrays.asList("Vova", "Dima"));
        List<MusicBand> bands = new ArrayList<MusicBand>();
        bands.add(musicBand1);
        bands.add(musicBand2);

        System.out.print("C����� �����: ");
        for(MusicBand x : bands) // ������������ ������ �����
            System.out.print(x.getName() + " | ");

        System.out.println();

        System.out.print("C����� ������������: ");
        for (MusicBand y : bands)
            System.out.println(y.getMembers());

        System.out.println();
        //��������� ������ ����� ����� ��������
        musicBand1.printMembers(); //������ ������ �
        musicBand2.printMembers(); //������ ������ �

        MusicBand.transferMembers(musicBand1, musicBand2); //��� ��������� ������ � ��������� � ������ B
        System.out.println("����������� ������� �� � ������ � ������ �: ");
        musicBand1.printMembers(); //��������� ������ ����� ����� �������
        musicBand2.printMembers(); //��������� ������ ����� ����� �������
    }
}

class MusicBand{ //����������� ������
    private String name; //�������� ����������� ������
    private int year; // ��� ���������
    private List<String> members =  new ArrayList<>(); //�������� ������

    // ����������� ��� ����������
    public MusicBand() {
        this.name = null;  // �������������� ������ �������
        this.members = new ArrayList<>();  // �������������� ������ �������
        // ���� year ����� �� ��������� ���������������� 0
    }


    // ����������� �� ����� �����������
    public MusicBand(String name, int year, List<String> members){
        this.name = name;
        this.year = year;
        this.members = members;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public List<String> getMembers() {
        return members;
    }

    public void setMembers(List<String> members) {
        this.members = members;
    }
    public static void transferMembers(MusicBand a, MusicBand b){ //����������� ����������� ����� ������� ����� (� ������ MusicBand), �.�. ��� ��������� ������ � ��������� � ������ B. �������� ������: transferMembers. ���� ����� ��������� � �������� ���������� ��� ���������� ������ MusicBand.
        List<String> members = new ArrayList<>(List.copyOf(b.getMembers())); //������� ����� ������ ������� ���������� ������ �
        members.addAll(a.getMembers()); //��������� � ������ ���������� ������ �
        b.setMembers(members); //������������� ���� ���������� ������ ������� � ������ �
        a.setMembers(new ArrayList<>()); //������� ������� ����� ������ ��� ������ �
    }

    public void printMembers() {
        System.out.println(getMembers());
    }
}
