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

        System.out.print("Cписок групп: ");
        for(MusicBand x : bands) // ОРИГИНАЛЬНЫЙ СПИСОК ГРУПП
            System.out.print(x.getName() + " | ");

        System.out.println();

        System.out.print("Cписок исполнителей: ");
        for (MusicBand y : bands)
            System.out.println(y.getMembers());

        System.out.println();
        //Проверяем состав групп перед слиянием
        musicBand1.printMembers(); //состав группы А
        musicBand2.printMembers(); //состав группы Б

        MusicBand.transferMembers(musicBand1, musicBand2); //все участники группы А переходят в группу B
        System.out.println("Исполнители перешли из А группы в группу Б: ");
        musicBand1.printMembers(); //Проверить состав групп после слияния
        musicBand2.printMembers(); //Проверить состав групп после слияния
    }
}

class MusicBand{ //Музыкальная Группа
    private String name; //название музыкальной группы
    private int year; // год основания
    private List<String> members =  new ArrayList<>(); //участник группы

    // Конструктор без аргументов
    public MusicBand() {
        this.name = null;  // инициализируем пустой строкой
        this.members = new ArrayList<>();  // инициализируем пустым списком
        // поле year будет по умолчанию инициализировано 0
    }


    // Конструктор со всеми аргументами
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
    public static void transferMembers(MusicBand a, MusicBand b){ //Реализовать статический метод слияния групп (в классе MusicBand), т.е. все участники группы А переходят в группу B. Название метода: transferMembers. Этот метод принимает в качестве аргументов два экземпляра класса MusicBand.
        List<String> members = new ArrayList<>(List.copyOf(b.getMembers())); //создаем новый массив копируя участников груббы Б
        members.addAll(a.getMembers()); //добавляем в массив участников группы А
        b.setMembers(members); //устанавливаем всех участников нового массива в группу Б
        a.setMembers(new ArrayList<>()); //создаем пустной новый массив для группы А
    }

    public void printMembers() {
        System.out.println(getMembers());
    }
}
