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
        bands.add(musicBand10); //можно так, а можно и с Arrays.asList()

        Collections.shuffle(bands);  //перемешиваем список

        System.out.print("Оригинальный список групп: ");
        for(MusicBand x : bands) // ОРИГИНАЛЬНЫЙ СПИСОК ГРУПП
            System.out.print(x.getName() + " | ");

        System.out.println(); //отступ

        groupsAfter2000(bands); // Вызваем метод groupsAfter2000(List<MusicBand> bands) в методе main() на нашем списке

        System.out.println("Музыкалные гуппы, основанные после 2000 года: ");
        for(MusicBand x : bands) // СПИСОК ГРУПП основанные после 2005 года
            System.out.print(x.getName() + " | ");


    }

    public static List<MusicBand> groupsAfter2000(List<MusicBand> bands) {
        Iterator<MusicBand> bandsIterator = bands.iterator();//создаем итератор
        while(bandsIterator.hasNext()) {//до тех пор, пока в списке есть элементы
            MusicBand nextBand = bandsIterator.next();//получаем следующий элемент
            if (nextBand.getYear() < 2000) {
                bandsIterator.remove();//удаляем группу
            }
        }
        return bands;
    }

}


class MusicBand{ //Музыкальная Группа
    private String name; //название музыкальной группы
    private int year; // год основания

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