package day7;


import java.util.Random;

public class Task2 {
    public static void main(String[] args) {
        Random random = new Random();
        int i = random.nextInt((100-90)+1)+90;
        Player player1 = new Player("Иван",i);
        player1.info();
        Player player2 = new Player("Вова",i);
        player1.info();
        Player player3 = new Player("Коля",i);
        player1.info();
        Player player4 = new Player("Вася",i);
        player1.info();
        Player player5 = new Player("Петя",i);
        player1.info();
        Player player6 = new Player("Петя",i);
        player1.info();
        Player player7 = new Player("Сережа",i);
        player1.info();
        player1.run();

    }
}

class Player{
    private String namePlayer;
    private int stamina;
    public final int MAX_STAMINA = 100;
    public final int MIN_STAMINA = 0;
    public static int countPlayers = 0;

    public Player(String namePlayer,int stamina){
        this.stamina = stamina;
        this.namePlayer = namePlayer;
        countPlayers++;
        if(countPlayers>=7){
            System.out.println("Много игроков на поле " + countPlayers + ".");
            countPlayers--;
            System.out.println("Судья удалил лишнего игрока. Теперь их опять " + countPlayers + ".");
        }
    }
    public int getStamina(){
        return stamina;
    }
    public int getCountPlayers(){
        return countPlayers;
    }

    public void run(){
        //System.out.println(stamina);
        for(int j = 0; j<=MAX_STAMINA; j++){
        stamina--;
        //System.out.println(stamina);
        }
        if(stamina <= MIN_STAMINA){
            countPlayers--;}
        System.out.println("Один игрок устал. На поле " + countPlayers + " игроков.");
    }
    public void info(){
        int i = 6 - countPlayers;
        if(countPlayers < 2){
        System.out.println("Команды неполные. На поле еще есть " + i + " свободных мест.");
        } else if(countPlayers < 3) {
            System.out.println("Команды неполные. На поле еще есть " + i + " свободных места.");
        } else if(countPlayers < 4) {
            System.out.println("Команды неполные. На поле еще есть " + i + " свободных места.");
        } else if(countPlayers < 5) {
            System.out.println("Команды неполные. На поле еще есть " + i + " свободных места.");
        } else if(countPlayers < 6) {
            System.out.println("Команды неполные. На поле еще есть " + i + " свободное место.");
        } else{
            System.out.println("На поле нет свободных мест. Сейчас " + countPlayers + " игроков.");
        }
    }



}