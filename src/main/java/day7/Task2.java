package day7;


import java.util.Random;

public class Task2 {
    public static void main(String[] args) {
        Random random = new Random();
        int i = random.nextInt((100-90)+1)+90;
        Player player1 = new Player("����",i);
        player1.info();
        Player player2 = new Player("����",i);
        player1.info();
        Player player3 = new Player("����",i);
        player1.info();
        Player player4 = new Player("����",i);
        player1.info();
        Player player5 = new Player("����",i);
        player1.info();
        Player player6 = new Player("����",i);
        player1.info();
        Player player7 = new Player("������",i);
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
            System.out.println("����� ������� �� ���� " + countPlayers + ".");
            countPlayers--;
            System.out.println("����� ������ ������� ������. ������ �� ����� " + countPlayers + ".");
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
        System.out.println("���� ����� �����. �� ���� " + countPlayers + " �������.");
    }
    public void info(){
        int i = 6 - countPlayers;
        if(countPlayers < 2){
        System.out.println("������� ��������. �� ���� ��� ���� " + i + " ��������� ����.");
        } else if(countPlayers < 3) {
            System.out.println("������� ��������. �� ���� ��� ���� " + i + " ��������� �����.");
        } else if(countPlayers < 4) {
            System.out.println("������� ��������. �� ���� ��� ���� " + i + " ��������� �����.");
        } else if(countPlayers < 5) {
            System.out.println("������� ��������. �� ���� ��� ���� " + i + " ��������� �����.");
        } else if(countPlayers < 6) {
            System.out.println("������� ��������. �� ���� ��� ���� " + i + " ��������� �����.");
        } else{
            System.out.println("�� ���� ��� ��������� ����. ������ " + countPlayers + " �������.");
        }
    }



}