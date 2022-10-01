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

        System.out.print("Cписок групп: ");
        for(MusicBand x : bands) // ОРИГИНАЛЬНЫЙ СПИСОК ГРУПП
            System.out.print(x.getName() + " | ");

        System.out.println();
        System.out.println("Исполнители всех групп: ");

        for(MusicBand x : bands) // список исполнителей всех групп
            for (MusicArtist y : x.getMembers())
                System.out.println(y.getName());

        System.out.println();
        //исполнители группы А
        //for (MusicArtist x : musicBand1.getMembers())
        //    System.out.println(x.getName());
        //исполнители группы Б
        //for (MusicArtist x : musicBand2.getMembers())
        //   System.out.println(x.getName());

        System.out.println();
        //Проверяем состав групп перед слиянием
        System.out.println("Исполнители группы А: ");
        musicBand1.printMembers(); //состав группы А
        System.out.println("Исполнители группы Б: ");
        musicBand2.printMembers(); //состав группы Б

        MusicBand.transferMembers(musicBand1, musicBand2); //все участники группы А переходят в группу B
        System.out.println("Исполнители перешли из А группы в группу Б: ");
        System.out.println("Исполнители группы А: ");
        musicBand1.printMembers(); //Проверить состав групп после слияния
        System.out.println("Исполнители группы Б: ");
        musicBand2.printMembers(); //Проверить состав групп после слияния

    }
}

class MusicArtist {
    private String name; //
    private int age; //возраст
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
class MusicBand{ //Музыкальная Группа
    private String name; //название музыкальной группы
    private int year; // год основания
    private List<MusicArtist> members; //участник группы

    // Конструктор без аргументов
    public MusicBand() {
        this.name = "";  // инициализируем пустой строкой
        this.members = new ArrayList<>();  // инициализируем пустым списком
        // поле year будет по умолчанию инициализировано 0
    }


    // Конструктор со всеми аргументами
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
    public static void transferMembers(MusicBand a, MusicBand b){ //Реализовать статический метод слияния групп (в классе MusicBand), т.е. все участники группы А переходят в группу B. Название метода: transferMembers. Этот метод принимает в качестве аргументов два экземпляра класса MusicBand.
        List<MusicArtist> members = new ArrayList<>(List.copyOf(b.getMembers())); //создаем новый массив копируя участников груббы Б
        members.addAll(a.getMembers()); //добавляем в массив участников группы А
        b.setMembers(members); //устанавливаем всех участников нового массива в группу Б
        a.setMembers(new ArrayList<>()); //создаем пустной новый массив для группы А
    }

    public void printMembers() {
        for (MusicArtist x : getMembers())
            System.out.println(x.printMusicArtist());
    }
}