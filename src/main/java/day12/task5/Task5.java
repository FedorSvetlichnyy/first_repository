package day12.task5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task5 {
    public static void main(String[] args) {
        MusicBand musicBand1 = new MusicBand("BalckYedPeace", 2001, Arrays.asList(new MusicArtist("Dasa", 52), new MusicArtist("Bgola", 46)));
        MusicBand musicBand2 = new MusicBand("Eminem", 1995, Arrays.asList(new MusicArtist("Sahsa", 23), new MusicArtist("Grisha", 27)));
        List<MusicBand> bands = new ArrayList<MusicBand>();
        bands.add(musicBand1);
        bands.add(musicBand2);

        System.out.print("C����� �����: ");
        for(MusicBand x : bands) // ������������ ������ �����
            System.out.print(x.getName() + " | ");

        System.out.println();
        System.out.println("����������� ���� �����: ");

        for(MusicBand x : bands) // ������ ������������ ���� �����
            for (MusicArtist y : x.getMembers())
                System.out.println(y.getName());

        System.out.println();
        //����������� ������ �
        //for (MusicArtist x : musicBand1.getMembers())
        //    System.out.println(x.getName());
        //����������� ������ �
        //for (MusicArtist x : musicBand2.getMembers())
        //   System.out.println(x.getName());

        System.out.println();
        //��������� ������ ����� ����� ��������
        System.out.println("����������� ������ �: ");
        musicBand1.printMembers(); //������ ������ �
        System.out.println("����������� ������ �: ");
        musicBand2.printMembers(); //������ ������ �

        MusicBand.transferMembers(musicBand1, musicBand2); //��� ��������� ������ � ��������� � ������ B
        System.out.println("����������� ������� �� � ������ � ������ �: ");
        System.out.println("����������� ������ �: ");
        musicBand1.printMembers(); //��������� ������ ����� ����� �������
        System.out.println("����������� ������ �: ");
        musicBand2.printMembers(); //��������� ������ ����� ����� �������

    }
}

class MusicArtist {
    private String name; //
    private int age; //�������
    public MusicArtist(String name, int age){
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String printMusicArtist(){
        return getName() + ", " + getAge();
    }
}
class MusicBand{ //����������� ������
    private String name; //�������� ����������� ������
    private int year; // ��� ���������
    private List<MusicArtist> members; //�������� ������

    // ����������� ��� ����������
    public MusicBand() {
        this.name = "";  // �������������� ������ �������
        this.members = new ArrayList<>();  // �������������� ������ �������
        // ���� year ����� �� ��������� ���������������� 0
    }


    // ����������� �� ����� �����������
    public MusicBand(String name, int year, List<MusicArtist> members){
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

    public List<MusicArtist> getMembers() {
        return members;
    }

    public void setMembers(List<MusicArtist> members) {
        this.members = members;
    }
    public static void transferMembers(MusicBand a, MusicBand b){ //����������� ����������� ����� ������� ����� (� ������ MusicBand), �.�. ��� ��������� ������ � ��������� � ������ B. �������� ������: transferMembers. ���� ����� ��������� � �������� ���������� ��� ���������� ������ MusicBand.
        List<MusicArtist> members = new ArrayList<>(List.copyOf(b.getMembers())); //������� ����� ������ ������� ���������� ������ �
        members.addAll(a.getMembers()); //��������� � ������ ���������� ������ �
        b.setMembers(members); //������������� ���� ���������� ������ ������� � ������ �
        a.setMembers(new ArrayList<>()); //������� ������� ����� ������ ��� ������ �
    }

    public void printMembers() {
        for (MusicArtist x : getMembers())
            System.out.println(x.printMusicArtist());
    }
}