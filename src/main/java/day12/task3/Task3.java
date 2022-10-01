package day12.task3;

import java.util.*;

public class Task3 {
    public static void main(String[] args) {
        MusicBand musicBand1 = new MusicBand("Nana", 1990);
        MusicBand musicBand2 = new MusicBand("Top", 2005);
        MusicBand musicBand3 = new MusicBand("Viva", 1998);
        MusicBand musicBand4 = new MusicBand("Group", 1979);
        MusicBand musicBand5 = new MusicBand("XFigters", 2010);
        MusicBand musicBand6 = new MusicBand("Evanesence", 1999);
        MusicBand musicBand7 = new MusicBand("NikelBack", 2001);
        MusicBand musicBand8 = new MusicBand("Eminem", 1989);
        MusicBand musicBand9 = new MusicBand("BYP", 1997);
        MusicBand musicBand10 = new MusicBand("Crash", 2011);
        //List<MusicBand> bands = new ArrayList<>(Arrays.asList(musicBand1, musicBand2, musicBand3, musicBand4, musicBand5, musicBand6, musicBand7, musicBand8, musicBand9, musicBand10));
        List<MusicBand> bands = new ArrayList<MusicBand>();
        bands.add(musicBand1);
        bands.add(musicBand2);
        bands.add(musicBand3);
        bands.add(musicBand4);
        bands.add(musicBand5);
        bands.add(musicBand6);
        bands.add(musicBand7);
        bands.add(musicBand8);
        bands.add(musicBand9);
        bands.add(musicBand10); //����� ���, � ����� � � Arrays.asList()

        Collections.shuffle(bands);  //������������ ������

        System.out.print("������������ ������ �����: ");
        for(MusicBand x : bands) // ������������ ������ �����
            System.out.print(x.getName() + " | ");

        System.out.println(); //������

        groupsAfter2000(bands); // ������� ����� groupsAfter2000(List<MusicBand> bands) � ������ main() �� ����� ������

        System.out.println("���������� �����, ���������� ����� 2000 ����: ");
        for(MusicBand x : bands) // ������ ����� ���������� ����� 2005 ����
            System.out.print(x.getName() + " | ");


    }

    public static List<MusicBand> groupsAfter2000(List<MusicBand> bands) {
        Iterator<MusicBand> bandsIterator = bands.iterator();//������� ��������
        while(bandsIterator.hasNext()) {//�� ��� ���, ���� � ������ ���� ��������
            MusicBand nextBand = bandsIterator.next();//�������� ��������� �������
            if (nextBand.getYear() < 2000) {
                bandsIterator.remove();//������� ������
            }
        }
        return bands;
    }

}


class MusicBand{ //����������� ������
    private String name; //�������� ����������� ������
    private int year; // ��� ���������

    public MusicBand(String name, int year){
        this.name = name;
        this.year = year;
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

    }