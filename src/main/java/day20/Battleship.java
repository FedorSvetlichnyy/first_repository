package day20;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;


public class Battleship {
    public static void main(String[] args) {
        BattlePiece[][] array1 = new BattlePiece[10][10];
        for (int i = 0; i < array1.length; i++) {
            for (int j = 0; j < array1[0].length; j++) {
                array1[i][j] = BattlePiece.EMPTY;
            }
        }
        BattlePiece[][] array2 = new BattlePiece[10][10];
        for (int i = 0; i < array2.length; i++) {
            for (int j = 0; j < array2[0].length; j++) {
                array2[i][j] = BattlePiece.EMPTY;
            }
        }
        Player player1 = new Player("Player1");
        Player player2 = new Player("Player2");
        PlayBoard playBoard1 = new PlayBoard(array1);
        PlayBoard playBoard2 = new PlayBoard(array2);

        placement(playBoard1, player1);
        placement(playBoard2, player2);
        System.out.println("----------------------------------------");
        playGame(playBoard1, playBoard2);
        playBoard1.print();
        System.out.println("----------------------------------------");
        playBoard2.print();
    }

    public static void placement(PlayBoard playBoard, Player player) {
        System.out.println("Начнем расставлять корабли на поле " + player.getName() + ". Другой игрок НЕ смотри!");
        System.out.println("Введите координаты четырехпалубного корабля (формат: х,у;x,y;x,y;x,y)");
        ship4(playBoard);
        System.out.println("Введите координаты первого трехпалубного корабля (формат: х,у;x,y;x,y)");
        ship3(playBoard);
        System.out.println("Введите координаты второго трехпалубного корабля (формат: х,у;x,y;x,y)");
        ship3(playBoard);
        System.out.println("Введите координаты первого двухпалубного корабля (формат: х,у;x,y)");
        ship2(playBoard);
        System.out.println("Введите координаты второго двухпалубного корабля (формат: х,у;x,y)");
        ship2(playBoard);
        System.out.println("Введите координаты третьего двухпалубного корабля (формат: х,у;x,y)");
        ship2(playBoard);
        System.out.println("Введите координаты первого однопалубного корабля (формат: х,у)");
        ship1(playBoard);
        System.out.println("Введите координаты второго однопалубного корабля (формат: х,у)");
        ship1(playBoard);
        System.out.println("Введите координаты третьего однопалубного корабля (формат: х,у)");
        ship1(playBoard);
        System.out.println("Введите координаты четвертого однопалубного корабля (формат: х,у)");
        ship1(playBoard);
    }

    public static void ship1(PlayBoard playBoard) {
        int x = 0;
        int y = 0;
        String[] strings2 = null;
        boolean check1;
        boolean check2;
        do {
            check1 = true;
            check2 = true;
            Scanner scanner = new Scanner(System.in);
            String strings = scanner.next();
            strings2 = strings.split(",");
            check2 = checkInt(strings2);
            if (check2 == true) {
                x = Integer.parseInt(strings2[0]);
                y = Integer.parseInt(strings2[1]);
            }
            check1 = check09(x, y, playBoard);
        } while (!check1 | !check2);


        playBoard.getArray()[y][x] = BattlePiece.SHIP;
        try {
            if (x == 0 && y == 0) {
                playBoard.getArray()[y + 1][x] = BattlePiece.HALO;
                playBoard.getArray()[y][x + 1] = BattlePiece.HALO;
                playBoard.getArray()[y + 1][x + 1] = BattlePiece.HALO;
            } else if (x == 9 && y == 9) {
                playBoard.getArray()[y - 1][x] = BattlePiece.HALO;
                playBoard.getArray()[y][x - 1] = BattlePiece.HALO;
                playBoard.getArray()[y - 1][x - 1] = BattlePiece.HALO;
            } else if (x == 9 && y == 0) {
                playBoard.getArray()[y + 1][x] = BattlePiece.HALO;
                playBoard.getArray()[y][x - 1] = BattlePiece.HALO;
                playBoard.getArray()[y + 1][x - 1] = BattlePiece.HALO;
            } else if (x == 0 && y == 9) {
                playBoard.getArray()[y - 1][x] = BattlePiece.HALO;
                playBoard.getArray()[y][x + 1] = BattlePiece.HALO;
                playBoard.getArray()[y - 1][x + 1] = BattlePiece.HALO;
            } else if (x == 0) {
                playBoard.getArray()[y - 1][x] = BattlePiece.HALO;
                playBoard.getArray()[y][x + 1] = BattlePiece.HALO;
                playBoard.getArray()[y + 1][x] = BattlePiece.HALO;
                playBoard.getArray()[y + 1][x + 1] = BattlePiece.HALO;
                playBoard.getArray()[y - 1][x + 1] = BattlePiece.HALO;
            } else if (y == 0) {
                playBoard.getArray()[y][x + 1] = BattlePiece.HALO;
                playBoard.getArray()[y][x - 1] = BattlePiece.HALO;
                playBoard.getArray()[y + 1][x] = BattlePiece.HALO;
                playBoard.getArray()[y + 1][x + 1] = BattlePiece.HALO;
                playBoard.getArray()[y + 1][x - 1] = BattlePiece.HALO;
            } else if (x == 9) {
                playBoard.getArray()[y + 1][x] = BattlePiece.HALO;
                playBoard.getArray()[y][x - 1] = BattlePiece.HALO;
                playBoard.getArray()[y - 1][x] = BattlePiece.HALO;
                playBoard.getArray()[y - 1][x - 1] = BattlePiece.HALO;
                playBoard.getArray()[y + 1][x - 1] = BattlePiece.HALO;
            } else if (y == 9) {
                playBoard.getArray()[y][x - 1] = BattlePiece.HALO;
                playBoard.getArray()[y][x + 1] = BattlePiece.HALO;
                playBoard.getArray()[y - 1][x] = BattlePiece.HALO;
                playBoard.getArray()[y - 1][x - 1] = BattlePiece.HALO;
                playBoard.getArray()[y - 1][x + 1] = BattlePiece.HALO;
            } else {
                playBoard.getArray()[y - 1][x - 1] = BattlePiece.HALO;
                playBoard.getArray()[y][x - 1] = BattlePiece.HALO;
                playBoard.getArray()[y + 1][x - 1] = BattlePiece.HALO;
                playBoard.getArray()[y - 1][x] = BattlePiece.HALO;
                playBoard.getArray()[y + 1][x] = BattlePiece.HALO;
                playBoard.getArray()[y - 1][x + 1] = BattlePiece.HALO;
                playBoard.getArray()[y][x + 1] = BattlePiece.HALO;
                playBoard.getArray()[y + 1][x + 1] = BattlePiece.HALO;
            }
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Что-то с настройками ореола. Нужно проверить");
        }
    }

    public static void ship2(PlayBoard playBoard) {
        int x1 = 0;
        int y1 = 0;
        int x2 = 0;
        int y2 = 0;
        String[] strings2 = null;
        boolean check1;
        boolean check2;
        boolean check3;
        boolean check4;
        do {
            check1 = true;
            check2 = true;
            check3 = true;
            check4 = true;
            Scanner scanner = new Scanner(System.in);
            String strings = scanner.next();
            strings2 = strings.split("\\D");
            check2 = checkInt2(strings2);
            if (check2) {
                x1 = Integer.parseInt(strings2[0]);
                y1 = Integer.parseInt(strings2[1]);
                x2 = Integer.parseInt(strings2[2]);
                y2 = Integer.parseInt(strings2[3]);
            }
            check1 = check09(x1, y1, playBoard);
            check3 = check09(x2, y2, playBoard);
            check4 = checkValid2(x1, y1, x2, y2);
        } while (!check1 | !check2 | !check3 | !check4);

        playBoard.getArray()[y1][x1] = BattlePiece.SHIP;
        playBoard.getArray()[y2][x2] = BattlePiece.SHIP;


        try {
            if (x1 == 0 && y1 == 0 && x2 == 0 && y2 == 1) {
                playBoard.getArray()[y2 + 1][x2] = BattlePiece.HALO;
                playBoard.getArray()[y2 + 1][x2 + 1] = BattlePiece.HALO;
                playBoard.getArray()[y2][x2 + 1] = BattlePiece.HALO;
                playBoard.getArray()[y1][x1 + 1] = BattlePiece.HALO;
            } else if (x1 == 0 && y1 == 1 && x2 == 0 && y2 == 0) {
                playBoard.getArray()[y1 + 1][x1] = BattlePiece.HALO;
                playBoard.getArray()[y1 + 1][x1 + 1] = BattlePiece.HALO;
                playBoard.getArray()[y1][x1 + 1] = BattlePiece.HALO;
                playBoard.getArray()[y2][x2 + 1] = BattlePiece.HALO;
            } else if (x1 == 0 && y1 == 0 && x2 == 1 && y2 == 0) {
                playBoard.getArray()[y2 + 1][x2] = BattlePiece.HALO;
                playBoard.getArray()[y2][x2 + 1] = BattlePiece.HALO;
                playBoard.getArray()[y2 + 1][x2 + 1] = BattlePiece.HALO;
                playBoard.getArray()[y1 + 1][x1] = BattlePiece.HALO;
            } else if (x1 == 1 && y1 == 0 && x2 == 0 && y2 == 0) {
                playBoard.getArray()[y1 + 1][x1] = BattlePiece.HALO;
                playBoard.getArray()[y1][x1 + 1] = BattlePiece.HALO;
                playBoard.getArray()[y1 + 1][x1 + 1] = BattlePiece.HALO;
                playBoard.getArray()[y2 + 1][x2] = BattlePiece.HALO;
            } else if (x1 == 9 && y1 == 9 && x2 == 9 && y2 == 8) {
                playBoard.getArray()[y1][x1 - 1] = BattlePiece.HALO;
                playBoard.getArray()[y2][x2 - 1] = BattlePiece.HALO;
                playBoard.getArray()[y2 - 1][x2 - 1] = BattlePiece.HALO;
                playBoard.getArray()[y2 - 1][x2] = BattlePiece.HALO;
            } else if (x1 == 9 && y1 == 8 && x2 == 9 && y2 == 9) {
                playBoard.getArray()[y2][x2 - 1] = BattlePiece.HALO;
                playBoard.getArray()[y1][x1 - 1] = BattlePiece.HALO;
                playBoard.getArray()[y1 - 1][x1 - 1] = BattlePiece.HALO;
                playBoard.getArray()[y1 - 1][x1] = BattlePiece.HALO;
            } else if (x1 == 9 && y1 == 9 && x2 == 8 && y2 == 9) {
                playBoard.getArray()[y1 - 1][x1] = BattlePiece.HALO;
                playBoard.getArray()[y2][x2 - 1] = BattlePiece.HALO;
                playBoard.getArray()[y2 - 1][x2 - 1] = BattlePiece.HALO;
                playBoard.getArray()[y2 - 1][x2] = BattlePiece.HALO;
            } else if (x1 == 8 && y1 == 9 && x2 == 9 && y2 == 9) {
                playBoard.getArray()[y2 - 1][x2] = BattlePiece.HALO;
                playBoard.getArray()[y1][x1 - 1] = BattlePiece.HALO;
                playBoard.getArray()[y1 - 1][x1 - 1] = BattlePiece.HALO;
                playBoard.getArray()[y1 - 1][x1] = BattlePiece.HALO;
            } else if (x1 == 9 && y1 == 0 && x2 == 8 && y2 == 0) {
                playBoard.getArray()[y1 + 1][x1] = BattlePiece.HALO;
                playBoard.getArray()[y2 + 1][x2] = BattlePiece.HALO;
                playBoard.getArray()[y2 + 1][x2 - 1] = BattlePiece.HALO;
                playBoard.getArray()[y2][x2 - 1] = BattlePiece.HALO;
            } else if (x1 == 8 && y1 == 0 && x2 == 9 && y2 == 0) {
                playBoard.getArray()[y2 + 1][x2] = BattlePiece.HALO;
                playBoard.getArray()[y1 + 1][x1] = BattlePiece.HALO;
                playBoard.getArray()[y1 + 1][x1 - 1] = BattlePiece.HALO;
                playBoard.getArray()[y1][x1 - 1] = BattlePiece.HALO;
            } else if (x1 == 0 && y1 == 9 && x2 == 0 && y2 == 8) {
                playBoard.getArray()[y1][x1 + 1] = BattlePiece.HALO;
                playBoard.getArray()[y2][x2 + 1] = BattlePiece.HALO;
                playBoard.getArray()[y2 - 1][x2 + 1] = BattlePiece.HALO;
                playBoard.getArray()[y2 - 1][x2] = BattlePiece.HALO;
            } else if (x1 == 0 && y1 == 8 && x2 == 0 && y2 == 9) {
                playBoard.getArray()[y2][x2 + 1] = BattlePiece.HALO;
                playBoard.getArray()[y1][x1 + 1] = BattlePiece.HALO;
                playBoard.getArray()[y1 - 1][x1 + 1] = BattlePiece.HALO;
                playBoard.getArray()[y1 - 1][x1] = BattlePiece.HALO;
            } else if (x1 == 0 && x2 == 0 && y1 < y2) {
                playBoard.getArray()[y1 - 1][x1] = BattlePiece.HALO;
                playBoard.getArray()[y1][x1 + 1] = BattlePiece.HALO;
                playBoard.getArray()[y2 + 1][x2] = BattlePiece.HALO;
                playBoard.getArray()[y2 + 1][x2 + 1] = BattlePiece.HALO;
                playBoard.getArray()[y1 - 1][x1 + 1] = BattlePiece.HALO;
                playBoard.getArray()[y2][x2 + 1] = BattlePiece.HALO;
            } else if (x1 == 0 && x2 == 0 && y2 < y1) {
                playBoard.getArray()[y2 - 1][x2] = BattlePiece.HALO;
                playBoard.getArray()[y2][x2 + 1] = BattlePiece.HALO;
                playBoard.getArray()[y1 + 1][x1] = BattlePiece.HALO;
                playBoard.getArray()[y1 + 1][x1 + 1] = BattlePiece.HALO;
                playBoard.getArray()[y2 - 1][x2 + 1] = BattlePiece.HALO;
                playBoard.getArray()[y1][x1 + 1] = BattlePiece.HALO;
            } else if (x1 == 9 && x2 == 9 && y1 < y2) {
                playBoard.getArray()[y1 - 1][x1] = BattlePiece.HALO;
                playBoard.getArray()[y1][x1 - 1] = BattlePiece.HALO;
                playBoard.getArray()[y2][x2 - 1] = BattlePiece.HALO;
                playBoard.getArray()[y2 + 1][x2 - 1] = BattlePiece.HALO;
                playBoard.getArray()[y1 - 1][x1 - 1] = BattlePiece.HALO;
                playBoard.getArray()[y2 + 1][x2] = BattlePiece.HALO;
            } else if (x1 == 9 && x2 == 9 && y2 < y1) {
                playBoard.getArray()[y2 - 1][x2] = BattlePiece.HALO;
                playBoard.getArray()[y2][x2 - 1] = BattlePiece.HALO;
                playBoard.getArray()[y1][x1 - 1] = BattlePiece.HALO;
                playBoard.getArray()[y1 + 1][x1 - 1] = BattlePiece.HALO;
                playBoard.getArray()[y2 - 1][x2 - 1] = BattlePiece.HALO;
                playBoard.getArray()[y1 + 1][x1] = BattlePiece.HALO;
            } else if (y1 == 0 && y2 == 0 && x1 < x2) {
                playBoard.getArray()[y1][x1 - 1] = BattlePiece.HALO;
                playBoard.getArray()[y2 + 1][x2 + 1] = BattlePiece.HALO;
                playBoard.getArray()[y1 + 1][x1] = BattlePiece.HALO;
                playBoard.getArray()[y2 + 1][x2] = BattlePiece.HALO;
                playBoard.getArray()[y1 + 1][x1 - 1] = BattlePiece.HALO;
                playBoard.getArray()[y2][x2 + 1] = BattlePiece.HALO;
            } else if (y1 == 0 && y2 == 1) {
                playBoard.getArray()[y1][x1 - 1] = BattlePiece.HALO;
                playBoard.getArray()[y2][x2 - 1] = BattlePiece.HALO;
                playBoard.getArray()[y2 + 1][x2-1] = BattlePiece.HALO;
                playBoard.getArray()[y2 + 1][x2] = BattlePiece.HALO;
                playBoard.getArray()[y2 + 1][x2 + 1] = BattlePiece.HALO;
                playBoard.getArray()[y2][x2 + 1] = BattlePiece.HALO;
                playBoard.getArray()[y1][x1 + 1] = BattlePiece.HALO;
            } else if (y1 == 9 && y2 == 9 && x1 < x2) {
                playBoard.getArray()[y1][x1 - 1] = BattlePiece.HALO;
                playBoard.getArray()[y1 - 1][x1 - 1] = BattlePiece.HALO;
                playBoard.getArray()[y1 - 1][x1] = BattlePiece.HALO;
                playBoard.getArray()[y2 - 1][x2] = BattlePiece.HALO;
                playBoard.getArray()[y2 - 1][x2 + 1] = BattlePiece.HALO;
                playBoard.getArray()[y2][x2 + 1] = BattlePiece.HALO;
            } else if (y1 == 9 && y2 == 9 && x2 < x1) {
                playBoard.getArray()[y2][x2 - 1] = BattlePiece.HALO;
                playBoard.getArray()[y2 - 1][x2 - 1] = BattlePiece.HALO;
                playBoard.getArray()[y2 - 1][x2] = BattlePiece.HALO;
                playBoard.getArray()[y1 - 1][x1] = BattlePiece.HALO;
                playBoard.getArray()[y1 - 1][x1 + 1] = BattlePiece.HALO;
                playBoard.getArray()[y1][x1 + 1] = BattlePiece.HALO;
            } else if (x1 < x2) {
                playBoard.getArray()[y1 - 1][x1 - 1] = BattlePiece.HALO;
                playBoard.getArray()[y1 - 1][x1] = BattlePiece.HALO;
                playBoard.getArray()[y2 - 1][x2] = BattlePiece.HALO;
                playBoard.getArray()[y2 - 1][x2 + 1] = BattlePiece.HALO;
                playBoard.getArray()[y2][x2 + 1] = BattlePiece.HALO;
                playBoard.getArray()[y2 + 1][x2 + 1] = BattlePiece.HALO;
                playBoard.getArray()[y2 + 1][x2] = BattlePiece.HALO;
                playBoard.getArray()[y1 + 1][x1] = BattlePiece.HALO;
                playBoard.getArray()[y1 + 1][x1 - 1] = BattlePiece.HALO;
                playBoard.getArray()[y1][x1 - 1] = BattlePiece.HALO;
            } else if (x2 < x1) {
                playBoard.getArray()[y1 - 1][x1 + 1] = BattlePiece.HALO;
                playBoard.getArray()[y1 - 1][x1] = BattlePiece.HALO;
                playBoard.getArray()[y2 - 1][x2] = BattlePiece.HALO;
                playBoard.getArray()[y2 - 1][x2 - 1] = BattlePiece.HALO;
                playBoard.getArray()[y2][x2 - 1] = BattlePiece.HALO;
                playBoard.getArray()[y2 + 1][x2 - 1] = BattlePiece.HALO;
                playBoard.getArray()[y2 + 1][x2] = BattlePiece.HALO;
                playBoard.getArray()[y1 + 1][x1] = BattlePiece.HALO;
                playBoard.getArray()[y1 + 1][x1 + 1] = BattlePiece.HALO;
                playBoard.getArray()[y1][x1 + 1] = BattlePiece.HALO;
            } else if (y1 < y2) {
                playBoard.getArray()[y1 - 1][x1 - 1] = BattlePiece.HALO;
                playBoard.getArray()[y1 - 1][x1] = BattlePiece.HALO;
                playBoard.getArray()[y1 - 1][x1 + 1] = BattlePiece.HALO;
                playBoard.getArray()[y1][x1 + 1] = BattlePiece.HALO;
                playBoard.getArray()[y2][x2 + 1] = BattlePiece.HALO;
                playBoard.getArray()[y2 + 1][x2 + 1] = BattlePiece.HALO;
                playBoard.getArray()[y2 + 1][x2] = BattlePiece.HALO;
                playBoard.getArray()[y2 + 1][x1 - 1] = BattlePiece.HALO;
                playBoard.getArray()[y2][x2 - 1] = BattlePiece.HALO;
                playBoard.getArray()[y1][x1 - 1] = BattlePiece.HALO;
            } else if (y2 < y1) {
                playBoard.getArray()[y1 + 1][x1 - 1] = BattlePiece.HALO;
                playBoard.getArray()[y1][x1 - 1] = BattlePiece.HALO;
                playBoard.getArray()[y2][x2 - 1] = BattlePiece.HALO;
                playBoard.getArray()[y2 - 1][x2 - 1] = BattlePiece.HALO;
                playBoard.getArray()[y2 - 1][x2] = BattlePiece.HALO;
                playBoard.getArray()[y2 - 1][x2 + 1] = BattlePiece.HALO;
                playBoard.getArray()[y2][x2 + 1] = BattlePiece.HALO;
                playBoard.getArray()[y1][x1 + 1] = BattlePiece.HALO;
                playBoard.getArray()[y1 + 1][x1 + 1] = BattlePiece.HALO;
                playBoard.getArray()[y1 + 1][x1] = BattlePiece.HALO;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Что-то с настройками ореола. Нужно проверить");
        }
    }

    public static void ship3(PlayBoard playBoard) {
        int x1 = 0;
        int y1 = 0;
        int x2 = 0;
        int y2 = 0;
        int x3 = 0;
        int y3 = 0;
        String[] strings2 = null;
        boolean check1;
        boolean check2;
        boolean check3;
        boolean check4;
        boolean check5;
        do {
            check1 = true;
            check2 = true;
            check3 = true;
            check4 = true;
            check5 = true;
            Scanner scanner = new Scanner(System.in);
            String strings = scanner.next();
            strings2 = strings.split("\\D");
            check2 = checkInt3(strings2);
            if (check2 == true) {
                x1 = Integer.parseInt(strings2[0]);
                y1 = Integer.parseInt(strings2[1]);
                x2 = Integer.parseInt(strings2[2]);
                y2 = Integer.parseInt(strings2[3]);
                x3 = Integer.parseInt(strings2[4]);
                y3 = Integer.parseInt(strings2[5]);
            }
            check1 = check09(x1, y1, playBoard);
            check3 = check09(x2, y2, playBoard);
            check5 = check09(x3, y3, playBoard);
            check4 = checkValid3(x1, y1, x2, y2, x3, y3);
        } while (!check1 | !check2 | !check3 | !check4 | !check5);

        playBoard.getArray()[y1][x1] = BattlePiece.SHIP;
        playBoard.getArray()[y2][x2] = BattlePiece.SHIP;
        playBoard.getArray()[y3][x3] = BattlePiece.SHIP;

        try {
            if (x1 == 0 && y1 == 0 && x2 == 0 && y2 == 1 && x3 == 0 && y3 == 2) {
                playBoard.getArray()[y3 + 1][x3] = BattlePiece.HALO;
                playBoard.getArray()[y3 + 1][x3 + 1] = BattlePiece.HALO;
                playBoard.getArray()[y3][x3 + 1] = BattlePiece.HALO;
                playBoard.getArray()[y2][x2 + 1] = BattlePiece.HALO;
                playBoard.getArray()[y1][x1 + 1] = BattlePiece.HALO;
            } else if (x1 == 0 && y1 == 2 && x2 == 0 && y2 == 1 && x3 == 0 && y3 == 0) {
                playBoard.getArray()[y1 + 1][x1] = BattlePiece.HALO;
                playBoard.getArray()[y1 + 1][x1 + 1] = BattlePiece.HALO;
                playBoard.getArray()[y1][x1 + 1] = BattlePiece.HALO;
                playBoard.getArray()[y2][x2 + 1] = BattlePiece.HALO;
                playBoard.getArray()[y3][x3 + 1] = BattlePiece.HALO;
            } else if (x1 == 0 && y1 == 0 && x2 == 1 && y2 == 0 && x3 == 2 && y3 == 0) {
                playBoard.getArray()[y3 + 1][x3] = BattlePiece.HALO;
                playBoard.getArray()[y3][x3 + 1] = BattlePiece.HALO;
                playBoard.getArray()[y3 + 1][x3 + 1] = BattlePiece.HALO;
                playBoard.getArray()[y1 + 1][x1] = BattlePiece.HALO;
                playBoard.getArray()[y2 + 1][x2] = BattlePiece.HALO;
            } else if (x1 == 2 && y1 == 0 && x2 == 1 && y2 == 0 && x3 == 0 && y3 == 0) {
                playBoard.getArray()[y1 + 1][x1] = BattlePiece.HALO;
                playBoard.getArray()[y1][x1 + 1] = BattlePiece.HALO;
                playBoard.getArray()[y1 + 1][x1 + 1] = BattlePiece.HALO;
                playBoard.getArray()[y2 + 1][x2] = BattlePiece.HALO;
                playBoard.getArray()[y3 + 1][x3] = BattlePiece.HALO;
            } else if (x1 == 9 && y1 == 9 && x2 == 9 && y2 == 8 && x3 == 9 && y3 == 7) {
                playBoard.getArray()[y1][x1 - 1] = BattlePiece.HALO;
                playBoard.getArray()[y2][x2 - 1] = BattlePiece.HALO;
                playBoard.getArray()[y3][x3 - 1] = BattlePiece.HALO;
                playBoard.getArray()[y3 - 1][x3 - 1] = BattlePiece.HALO;
                playBoard.getArray()[y3 - 1][x3] = BattlePiece.HALO;
            } else if (x1 == 9 && y1 == 7 && x2 == 9 && y2 == 8 && x3 == 9 && y3 == 9) {
                playBoard.getArray()[y3][x3 - 1] = BattlePiece.HALO;
                playBoard.getArray()[y2][x2 - 1] = BattlePiece.HALO;
                playBoard.getArray()[y1][x1 - 1] = BattlePiece.HALO;
                playBoard.getArray()[y1 - 1][x1 - 1] = BattlePiece.HALO;
                playBoard.getArray()[y1 - 1][x1] = BattlePiece.HALO;
            } else if (x1 == 9 && y1 == 9 && x2 == 8 && y2 == 9 && x3 == 7 && y3 == 9) {
                playBoard.getArray()[y1 - 1][x1] = BattlePiece.HALO;
                playBoard.getArray()[y3][x3 - 1] = BattlePiece.HALO;
                playBoard.getArray()[y3 - 1][x3 - 1] = BattlePiece.HALO;
                playBoard.getArray()[y2 - 1][x2] = BattlePiece.HALO;
                playBoard.getArray()[y3 - 1][x3] = BattlePiece.HALO;
            } else if (x1 == 7 && y1 == 9 && x2 == 8 && y2 == 9 && x3 == 9 && y3 == 9) {
                playBoard.getArray()[y2 - 1][x2] = BattlePiece.HALO;
                playBoard.getArray()[y1][x1 - 1] = BattlePiece.HALO;
                playBoard.getArray()[y1 - 1][x1 - 1] = BattlePiece.HALO;
                playBoard.getArray()[y1 - 1][x1] = BattlePiece.HALO;
                playBoard.getArray()[y3 - 1][x3] = BattlePiece.HALO;
            } else if (x1 == 9 && y1 == 0 && x2 == 8 && y2 == 0 && x3 == 7 && y3 == 0) {
                playBoard.getArray()[y1 + 1][x1] = BattlePiece.HALO;
                playBoard.getArray()[y2 + 1][x2] = BattlePiece.HALO;
                playBoard.getArray()[y3 + 1][x3] = BattlePiece.HALO;
                playBoard.getArray()[y3 + 1][x3 - 1] = BattlePiece.HALO;
                playBoard.getArray()[y3][x3 - 1] = BattlePiece.HALO;
            } else if (x1 == 7 && y1 == 0 && x2 == 8 && y2 == 0 && x3 == 9 && y3 == 0) {
                playBoard.getArray()[y3 + 1][x3] = BattlePiece.HALO;
                playBoard.getArray()[y2 + 1][x2] = BattlePiece.HALO;
                playBoard.getArray()[y1 + 1][x1] = BattlePiece.HALO;
                playBoard.getArray()[y1 + 1][x1 - 1] = BattlePiece.HALO;
                playBoard.getArray()[y1][x1 - 1] = BattlePiece.HALO;
            } else if (x1 == 0 && y1 == 9 && x2 == 0 && y2 == 8 && x3 == 0 && y3 == 7) {
                playBoard.getArray()[y1][x1 + 1] = BattlePiece.HALO;
                playBoard.getArray()[y2][x2 + 1] = BattlePiece.HALO;
                playBoard.getArray()[y3][x3 + 1] = BattlePiece.HALO;
                playBoard.getArray()[y3 - 1][x3 + 1] = BattlePiece.HALO;
                playBoard.getArray()[y3 - 1][x3] = BattlePiece.HALO;
            } else if (x1 == 0 && y1 == 7 && x2 == 0 && y2 == 8 && x3 == 0 && y3 == 9) {
                playBoard.getArray()[y3][x3 + 1] = BattlePiece.HALO;
                playBoard.getArray()[y2][x2 + 1] = BattlePiece.HALO;
                playBoard.getArray()[y1][x1 + 1] = BattlePiece.HALO;
                playBoard.getArray()[y1 - 1][x1 + 1] = BattlePiece.HALO;
                playBoard.getArray()[y1 - 1][x1] = BattlePiece.HALO;
            } else if (x1 == 0 && x2 == 0 && y1 < y2) {
                playBoard.getArray()[y1 - 1][x1] = BattlePiece.HALO;
                playBoard.getArray()[y1][x1 + 1] = BattlePiece.HALO;
                playBoard.getArray()[y2][x2 + 1] = BattlePiece.HALO;
                playBoard.getArray()[y3 + 1][x3] = BattlePiece.HALO;
                playBoard.getArray()[y3 + 1][x3 + 1] = BattlePiece.HALO;
                playBoard.getArray()[y1 - 1][x1 + 1] = BattlePiece.HALO;
                playBoard.getArray()[y3][x3 + 1] = BattlePiece.HALO;
            } else if (x1 == 0 && x2 == 0 && y2 < y1) {
                playBoard.getArray()[y3 - 1][x3] = BattlePiece.HALO;
                playBoard.getArray()[y3][x3 + 1] = BattlePiece.HALO;
                playBoard.getArray()[y2][x2 + 1] = BattlePiece.HALO;
                playBoard.getArray()[y1 + 1][x1] = BattlePiece.HALO;
                playBoard.getArray()[y1 + 1][x1 + 1] = BattlePiece.HALO;
                playBoard.getArray()[y3 - 1][x3 + 1] = BattlePiece.HALO;
                playBoard.getArray()[y1][x1 + 1] = BattlePiece.HALO;
            } else if (x1 == 9 && x2 == 9 && y1 < y2) {
                playBoard.getArray()[y1 - 1][x1] = BattlePiece.HALO;
                playBoard.getArray()[y1][x1 - 1] = BattlePiece.HALO;
                playBoard.getArray()[y2][x2 - 1] = BattlePiece.HALO;
                playBoard.getArray()[y3][x3 - 1] = BattlePiece.HALO;
                playBoard.getArray()[y3 + 1][x3 - 1] = BattlePiece.HALO;
                playBoard.getArray()[y1 - 1][x1 - 1] = BattlePiece.HALO;
                playBoard.getArray()[y3 + 1][x3] = BattlePiece.HALO;
            } else if (x1 == 9 && x2 == 9 && y2 < y1) {
                playBoard.getArray()[y3 - 1][x3] = BattlePiece.HALO;
                playBoard.getArray()[y3][x3 - 1] = BattlePiece.HALO;
                playBoard.getArray()[y3 - 1][x3 - 1] = BattlePiece.HALO;
                playBoard.getArray()[y2][x2 - 1] = BattlePiece.HALO;
                playBoard.getArray()[y1][x1 - 1] = BattlePiece.HALO;
                playBoard.getArray()[y1 + 1][x1 - 1] = BattlePiece.HALO;
                playBoard.getArray()[y1 + 1][x1] = BattlePiece.HALO;
            } else if (y1 == 0 && y2 == 0 && x1 < x2) {
                playBoard.getArray()[y1][x1 - 1] = BattlePiece.HALO;
                playBoard.getArray()[y2 + 1][x2 + 1] = BattlePiece.HALO;
                playBoard.getArray()[y1 + 1][x1] = BattlePiece.HALO;
                playBoard.getArray()[y2 + 1][x2] = BattlePiece.HALO;
                playBoard.getArray()[y1 + 1][x1 - 1] = BattlePiece.HALO;
                playBoard.getArray()[y2][x2 + 1] = BattlePiece.HALO;
            } else if (y1 == 9 && y2 == 9 && x1 < x2) {
                playBoard.getArray()[y1][x1 - 1] = BattlePiece.HALO;
                playBoard.getArray()[y1 - 1][x1 - 1] = BattlePiece.HALO;
                playBoard.getArray()[y1 - 1][x1] = BattlePiece.HALO;
                playBoard.getArray()[y2 - 1][x2] = BattlePiece.HALO;
                playBoard.getArray()[y3 - 1][x3] = BattlePiece.HALO;
                playBoard.getArray()[y3 - 1][x3 + 1] = BattlePiece.HALO;
                playBoard.getArray()[y3][x3 + 1] = BattlePiece.HALO;
            } else if (y1 == 9 && y2 == 9 && x2 < x1) {
                playBoard.getArray()[y3][x3 - 1] = BattlePiece.HALO;
                playBoard.getArray()[y3 - 1][x3 - 1] = BattlePiece.HALO;
                playBoard.getArray()[y3 - 1][x3] = BattlePiece.HALO;
                playBoard.getArray()[y2 - 1][x2] = BattlePiece.HALO;
                playBoard.getArray()[y1 - 1][x1] = BattlePiece.HALO;
                playBoard.getArray()[y1 - 1][x1 + 1] = BattlePiece.HALO;
                playBoard.getArray()[y1][x1 + 1] = BattlePiece.HALO;
            } else if (x1 < x2) {
                playBoard.getArray()[y1 - 1][x1 - 1] = BattlePiece.HALO;
                playBoard.getArray()[y1 - 1][x1] = BattlePiece.HALO;
                playBoard.getArray()[y2 - 1][x2] = BattlePiece.HALO;
                playBoard.getArray()[y3 - 1][x3] = BattlePiece.HALO;
                playBoard.getArray()[y3 - 1][x3 + 1] = BattlePiece.HALO;
                playBoard.getArray()[y3][x3 + 1] = BattlePiece.HALO;
                playBoard.getArray()[y3 + 1][x3 + 1] = BattlePiece.HALO;
                playBoard.getArray()[y3 + 1][x3] = BattlePiece.HALO;
                playBoard.getArray()[y2 + 1][x2] = BattlePiece.HALO;
                playBoard.getArray()[y1 + 1][x1] = BattlePiece.HALO;
                playBoard.getArray()[y1 + 1][x1 - 1] = BattlePiece.HALO;
                playBoard.getArray()[y1][x1 - 1] = BattlePiece.HALO;
            } else if (x2 < x1) {
                playBoard.getArray()[y1 - 1][x1 + 1] = BattlePiece.HALO;
                playBoard.getArray()[y1 - 1][x1] = BattlePiece.HALO;
                playBoard.getArray()[y2 - 1][x2] = BattlePiece.HALO;
                playBoard.getArray()[y3 - 1][x3] = BattlePiece.HALO;
                playBoard.getArray()[y3 - 1][x3 - 1] = BattlePiece.HALO;
                playBoard.getArray()[y3][x3 - 1] = BattlePiece.HALO;
                playBoard.getArray()[y3 + 1][x3 - 1] = BattlePiece.HALO;
                playBoard.getArray()[y3 + 1][x3] = BattlePiece.HALO;
                playBoard.getArray()[y2 + 1][x2] = BattlePiece.HALO;
                playBoard.getArray()[y1 + 1][x1] = BattlePiece.HALO;
                playBoard.getArray()[y1 + 1][x1 + 1] = BattlePiece.HALO;
                playBoard.getArray()[y1][x1 + 1] = BattlePiece.HALO;
            } else if (y1 < y2) {
                playBoard.getArray()[y1 - 1][x1 - 1] = BattlePiece.HALO;
                playBoard.getArray()[y1 - 1][x1] = BattlePiece.HALO;
                playBoard.getArray()[y1 - 1][x1 + 1] = BattlePiece.HALO;
                playBoard.getArray()[y1][x1 + 1] = BattlePiece.HALO;
                playBoard.getArray()[y2][x2 + 1] = BattlePiece.HALO;
                playBoard.getArray()[y3][x3 + 1] = BattlePiece.HALO;
                playBoard.getArray()[y3 + 1][x3 + 1] = BattlePiece.HALO;
                playBoard.getArray()[y3 + 1][x3] = BattlePiece.HALO;
                playBoard.getArray()[y3 + 1][x3 - 1] = BattlePiece.HALO;
                playBoard.getArray()[y3][x3 - 1] = BattlePiece.HALO;
                playBoard.getArray()[y2][x2 - 1] = BattlePiece.HALO;
                playBoard.getArray()[y1][x1 - 1] = BattlePiece.HALO;
            } else if (y2 < y1) {
                playBoard.getArray()[y1 + 1][x1 - 1] = BattlePiece.HALO;
                playBoard.getArray()[y1][x1 - 1] = BattlePiece.HALO;
                playBoard.getArray()[y2][x2 - 1] = BattlePiece.HALO;
                playBoard.getArray()[y3][x3 - 1] = BattlePiece.HALO;
                playBoard.getArray()[y3 - 1][x3 - 1] = BattlePiece.HALO;
                playBoard.getArray()[y3 - 1][x3] = BattlePiece.HALO;
                playBoard.getArray()[y3 - 1][x3 + 1] = BattlePiece.HALO;
                playBoard.getArray()[y3][x3 + 1] = BattlePiece.HALO;
                playBoard.getArray()[y2][x2 + 1] = BattlePiece.HALO;
                playBoard.getArray()[y1][x1 + 1] = BattlePiece.HALO;
                playBoard.getArray()[y1 + 1][x1 + 1] = BattlePiece.HALO;
                playBoard.getArray()[y1 + 1][x1] = BattlePiece.HALO;
            }
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Что-то с настройками ореола. Нужно проверить");
        }
    }

    public static void ship4(PlayBoard playBoard) {
        int x1 = 0;
        int y1 = 0;
        int x2 = 0;
        int y2 = 0;
        int x3 = 0;
        int y3 = 0;
        int x4 = 0;
        int y4 = 0;
        String[] strings2 = null;
        boolean check1;
        boolean check2;
        boolean check3;
        boolean check4;
        boolean check5;
        boolean check6;
        do {
            check1 = true;
            check2 = true;
            check3 = true;
            check4 = true;
            check5 = true;
            check6 = true;
            Scanner scanner = new Scanner(System.in);
            String strings = scanner.next();
            strings2 = strings.split("\\D");
            check2 = checkInt4(strings2);
            if (check2 == true) {
                x1 = Integer.parseInt(strings2[0]);
                y1 = Integer.parseInt(strings2[1]);
                x2 = Integer.parseInt(strings2[2]);
                y2 = Integer.parseInt(strings2[3]);
                x3 = Integer.parseInt(strings2[4]);
                y3 = Integer.parseInt(strings2[5]);
                x4 = Integer.parseInt(strings2[6]);
                y4 = Integer.parseInt(strings2[7]);
            }
            check1 = check09(x1, y1, playBoard);
            check3 = check09(x2, y2, playBoard);
            check5 = check09(x3, y3, playBoard);
            check6 = check09(x4, y4, playBoard);
            check4 = checkValid4(x1, y1, x2, y2, x3, y3, x4, y4);
        } while (!check1 | !check2 | !check3 | !check4 | !check5 | !check6);

        playBoard.getArray()[y1][x1] = BattlePiece.SHIP;
        playBoard.getArray()[y2][x2] = BattlePiece.SHIP;
        playBoard.getArray()[y3][x3] = BattlePiece.SHIP;
        playBoard.getArray()[y4][x4] = BattlePiece.SHIP;

        try {
            if (x1 == 0 && y1 == 0 && x2 == 0 && y2 == 1 && x3 == 0 && y3 == 2) {
                playBoard.getArray()[y4 + 1][x4] = BattlePiece.HALO;
                playBoard.getArray()[y4 + 1][x4 + 1] = BattlePiece.HALO;
                playBoard.getArray()[y4][x4 + 1] = BattlePiece.HALO;
                playBoard.getArray()[y3][x3 + 1] = BattlePiece.HALO;
                playBoard.getArray()[y2][x2 + 1] = BattlePiece.HALO;
                playBoard.getArray()[y1][x1 + 1] = BattlePiece.HALO;
            } else if (x1 == 0 && y1 == 2 && x2 == 0 && y2 == 1 && x3 == 0 && y3 == 0) {
                playBoard.getArray()[y1 + 1][x1] = BattlePiece.HALO;
                playBoard.getArray()[y1 + 1][x1 + 1] = BattlePiece.HALO;
                playBoard.getArray()[y1][x1 + 1] = BattlePiece.HALO;
                playBoard.getArray()[y2][x2 + 1] = BattlePiece.HALO;
                playBoard.getArray()[y3][x3 + 1] = BattlePiece.HALO;
            } else if (x1 == 0 && y1 == 0 && x2 == 1 && y2 == 0 && x3 == 2 && y3 == 0) {
                playBoard.getArray()[y3 + 1][x3] = BattlePiece.HALO;
                playBoard.getArray()[y3][x3 + 1] = BattlePiece.HALO;
                playBoard.getArray()[y3 + 1][x3 + 1] = BattlePiece.HALO;
                playBoard.getArray()[y1 + 1][x1] = BattlePiece.HALO;
                playBoard.getArray()[y2 + 1][x2] = BattlePiece.HALO;
            } else if (x1 == 2 && y1 == 0 && x2 == 1 && y2 == 0 && x3 == 0 && y3 == 0) {
                playBoard.getArray()[y1 + 1][x1] = BattlePiece.HALO;
                playBoard.getArray()[y1][x1 + 1] = BattlePiece.HALO;
                playBoard.getArray()[y1 + 1][x1 + 1] = BattlePiece.HALO;
                playBoard.getArray()[y2 + 1][x2] = BattlePiece.HALO;
                playBoard.getArray()[y3 + 1][x3] = BattlePiece.HALO;
            } else if (x1 == 9 && y1 == 9 && x2 == 9 && y2 == 8 && x3 == 9 && y3 == 7) {
                playBoard.getArray()[y1][x1 - 1] = BattlePiece.HALO;
                playBoard.getArray()[y2][x2 - 1] = BattlePiece.HALO;
                playBoard.getArray()[y3][x3 - 1] = BattlePiece.HALO;
                playBoard.getArray()[y3 - 1][x3 - 1] = BattlePiece.HALO;
                playBoard.getArray()[y3 - 1][x3] = BattlePiece.HALO;
            } else if (x1 == 9 && y1 == 7 && x2 == 9 && y2 == 8 && x3 == 9 && y3 == 9) {
                playBoard.getArray()[y3][x3 - 1] = BattlePiece.HALO;
                playBoard.getArray()[y2][x2 - 1] = BattlePiece.HALO;
                playBoard.getArray()[y1][x1 - 1] = BattlePiece.HALO;
                playBoard.getArray()[y1 - 1][x1 - 1] = BattlePiece.HALO;
                playBoard.getArray()[y1 - 1][x1] = BattlePiece.HALO;
            } else if (x1 == 9 && y1 == 9 && x2 == 8 && y2 == 9 && x3 == 7 && y3 == 9) {
                playBoard.getArray()[y1 - 1][x1] = BattlePiece.HALO;
                playBoard.getArray()[y3][x3 - 1] = BattlePiece.HALO;
                playBoard.getArray()[y3 - 1][x3 - 1] = BattlePiece.HALO;
                playBoard.getArray()[y2 - 1][x2] = BattlePiece.HALO;
                playBoard.getArray()[y3 - 1][x3] = BattlePiece.HALO;
            } else if (x1 == 7 && y1 == 9 && x2 == 8 && y2 == 9 && x3 == 9 && y3 == 9) {
                playBoard.getArray()[y2 - 1][x2] = BattlePiece.HALO;
                playBoard.getArray()[y1][x1 - 1] = BattlePiece.HALO;
                playBoard.getArray()[y1 - 1][x1 - 1] = BattlePiece.HALO;
                playBoard.getArray()[y1 - 1][x1] = BattlePiece.HALO;
                playBoard.getArray()[y3 - 1][x3] = BattlePiece.HALO;
            } else if (x1 == 9 && y1 == 0 && x2 == 8 && y2 == 0 && x3 == 7 && y3 == 0) {
                playBoard.getArray()[y1 + 1][x1] = BattlePiece.HALO;
                playBoard.getArray()[y2 + 1][x2] = BattlePiece.HALO;
                playBoard.getArray()[y3 + 1][x3] = BattlePiece.HALO;
                playBoard.getArray()[y3 + 1][x3 - 1] = BattlePiece.HALO;
                playBoard.getArray()[y3][x3 - 1] = BattlePiece.HALO;
            } else if (x1 == 7 && y1 == 0 && x2 == 8 && y2 == 0 && x3 == 9 && y3 == 0) {
                playBoard.getArray()[y3 + 1][x3] = BattlePiece.HALO;
                playBoard.getArray()[y2 + 1][x2] = BattlePiece.HALO;
                playBoard.getArray()[y1 + 1][x1] = BattlePiece.HALO;
                playBoard.getArray()[y1 + 1][x1 - 1] = BattlePiece.HALO;
                playBoard.getArray()[y1][x1 - 1] = BattlePiece.HALO;
            } else if (x1 == 0 && y1 == 9 && x2 == 0 && y2 == 8 && x3 == 0 && y3 == 7) {
                playBoard.getArray()[y1][x1 + 1] = BattlePiece.HALO;
                playBoard.getArray()[y2][x2 + 1] = BattlePiece.HALO;
                playBoard.getArray()[y3][x3 + 1] = BattlePiece.HALO;
                playBoard.getArray()[y3 - 1][x3 + 1] = BattlePiece.HALO;
                playBoard.getArray()[y3 - 1][x3] = BattlePiece.HALO;
            } else if (x1 == 0 && y1 == 7 && x2 == 0 && y2 == 8 && x3 == 0 && y3 == 9) {
                playBoard.getArray()[y3][x3 + 1] = BattlePiece.HALO;
                playBoard.getArray()[y2][x2 + 1] = BattlePiece.HALO;
                playBoard.getArray()[y1][x1 + 1] = BattlePiece.HALO;
                playBoard.getArray()[y1 - 1][x1 + 1] = BattlePiece.HALO;
                playBoard.getArray()[y1 - 1][x1] = BattlePiece.HALO;
            } else if (x1 == 0 && x2 == 0 && y1 < y2) {
                playBoard.getArray()[y1 - 1][x1] = BattlePiece.HALO;
                playBoard.getArray()[y1][x1 + 1] = BattlePiece.HALO;
                playBoard.getArray()[y2][x2 + 1] = BattlePiece.HALO;
                playBoard.getArray()[y4 + 1][x4] = BattlePiece.HALO;
                playBoard.getArray()[y4 + 1][x4 + 1] = BattlePiece.HALO;
                playBoard.getArray()[y1 - 1][x1 + 1] = BattlePiece.HALO;
                playBoard.getArray()[y3][x3 + 1] = BattlePiece.HALO;
                playBoard.getArray()[y4][x4 + 1] = BattlePiece.HALO;
            } else if (x1 == 0 && x2 == 0 && y2 < y1) {
                playBoard.getArray()[y3 - 1][x3] = BattlePiece.HALO;
                playBoard.getArray()[y3][x3 + 1] = BattlePiece.HALO;
                playBoard.getArray()[y2][x2 + 1] = BattlePiece.HALO;
                playBoard.getArray()[y1 + 1][x1] = BattlePiece.HALO;
                playBoard.getArray()[y1 + 1][x1 + 1] = BattlePiece.HALO;
                playBoard.getArray()[y3 - 1][x3 + 1] = BattlePiece.HALO;
                playBoard.getArray()[y1][x1 + 1] = BattlePiece.HALO;
            } else if (x1 == 9 && x2 == 9 && y1 < y2) {
                playBoard.getArray()[y1 - 1][x1] = BattlePiece.HALO;
                playBoard.getArray()[y1][x1 - 1] = BattlePiece.HALO;
                playBoard.getArray()[y2][x2 - 1] = BattlePiece.HALO;
                playBoard.getArray()[y3][x3 - 1] = BattlePiece.HALO;
                playBoard.getArray()[y3 + 1][x3 - 1] = BattlePiece.HALO;
                playBoard.getArray()[y1 - 1][x1 - 1] = BattlePiece.HALO;
                playBoard.getArray()[y3 + 1][x3] = BattlePiece.HALO;
            } else if (x1 == 9 && x2 == 9 && y2 < y1) {
                playBoard.getArray()[y3 - 1][x3] = BattlePiece.HALO;
                playBoard.getArray()[y3][x3 - 1] = BattlePiece.HALO;
                playBoard.getArray()[y3 - 1][x3 - 1] = BattlePiece.HALO;
                playBoard.getArray()[y2][x2 - 1] = BattlePiece.HALO;
                playBoard.getArray()[y1][x1 - 1] = BattlePiece.HALO;
                playBoard.getArray()[y1 + 1][x1 - 1] = BattlePiece.HALO;
                playBoard.getArray()[y1 + 1][x1] = BattlePiece.HALO;
            } else if (y1 == 0 && y2 == 0 && x1 < x2) {
                playBoard.getArray()[y1][x1 - 1] = BattlePiece.HALO;
                playBoard.getArray()[y2 + 1][x2 + 1] = BattlePiece.HALO;
                playBoard.getArray()[y1 + 1][x1] = BattlePiece.HALO;
                playBoard.getArray()[y2 + 1][x2] = BattlePiece.HALO;
                playBoard.getArray()[y1 + 1][x1 - 1] = BattlePiece.HALO;
                playBoard.getArray()[y2][x2 + 1] = BattlePiece.HALO;
            } else if (y1 == 9 && y2 == 9 && x1 < x2) {
                playBoard.getArray()[y1][x1 - 1] = BattlePiece.HALO;
                playBoard.getArray()[y1 - 1][x1 - 1] = BattlePiece.HALO;
                playBoard.getArray()[y1 - 1][x1] = BattlePiece.HALO;
                playBoard.getArray()[y2 - 1][x2] = BattlePiece.HALO;
                playBoard.getArray()[y3 - 1][x3] = BattlePiece.HALO;
                playBoard.getArray()[y3 - 1][x3 + 1] = BattlePiece.HALO;
                playBoard.getArray()[y3][x3 + 1] = BattlePiece.HALO;
            } else if (y1 == 9 && y2 == 9 && x2 < x1) {
                playBoard.getArray()[y3][x3 - 1] = BattlePiece.HALO;
                playBoard.getArray()[y3 - 1][x3 - 1] = BattlePiece.HALO;
                playBoard.getArray()[y3 - 1][x3] = BattlePiece.HALO;
                playBoard.getArray()[y2 - 1][x2] = BattlePiece.HALO;
                playBoard.getArray()[y1 - 1][x1] = BattlePiece.HALO;
                playBoard.getArray()[y1 - 1][x1 + 1] = BattlePiece.HALO;
                playBoard.getArray()[y1][x1 + 1] = BattlePiece.HALO;
            } else if (x1 < x2) {
                playBoard.getArray()[y1 - 1][x1 - 1] = BattlePiece.HALO;
                playBoard.getArray()[y1 - 1][x1] = BattlePiece.HALO;
                playBoard.getArray()[y2 - 1][x2] = BattlePiece.HALO;
                playBoard.getArray()[y3 - 1][x3] = BattlePiece.HALO;
                playBoard.getArray()[y3 - 1][x3 + 1] = BattlePiece.HALO;
                playBoard.getArray()[y3][x3 + 1] = BattlePiece.HALO;
                playBoard.getArray()[y3 + 1][x3 + 1] = BattlePiece.HALO;
                playBoard.getArray()[y3 + 1][x3] = BattlePiece.HALO;
                playBoard.getArray()[y2 + 1][x2] = BattlePiece.HALO;
                playBoard.getArray()[y1 + 1][x1] = BattlePiece.HALO;
                playBoard.getArray()[y1 + 1][x1 - 1] = BattlePiece.HALO;
                playBoard.getArray()[y1][x1 - 1] = BattlePiece.HALO;
            } else if (x2 < x1) {
                playBoard.getArray()[y1 - 1][x1 + 1] = BattlePiece.HALO;
                playBoard.getArray()[y1 - 1][x1] = BattlePiece.HALO;
                playBoard.getArray()[y2 - 1][x2] = BattlePiece.HALO;
                playBoard.getArray()[y3 - 1][x3] = BattlePiece.HALO;
                playBoard.getArray()[y3 - 1][x3 - 1] = BattlePiece.HALO;
                playBoard.getArray()[y3][x3 - 1] = BattlePiece.HALO;
                playBoard.getArray()[y3 + 1][x3 - 1] = BattlePiece.HALO;
                playBoard.getArray()[y3 + 1][x3] = BattlePiece.HALO;
                playBoard.getArray()[y2 + 1][x2] = BattlePiece.HALO;
                playBoard.getArray()[y1 + 1][x1] = BattlePiece.HALO;
                playBoard.getArray()[y1 + 1][x1 + 1] = BattlePiece.HALO;
                playBoard.getArray()[y1][x1 + 1] = BattlePiece.HALO;
            } else if (y1 < y2) {
                playBoard.getArray()[y1 - 1][x1 - 1] = BattlePiece.HALO;
                playBoard.getArray()[y1 - 1][x1] = BattlePiece.HALO;
                playBoard.getArray()[y1 - 1][x1 + 1] = BattlePiece.HALO;
                playBoard.getArray()[y1][x1 + 1] = BattlePiece.HALO;
                playBoard.getArray()[y2][x2 + 1] = BattlePiece.HALO;
                playBoard.getArray()[y3][x3 + 1] = BattlePiece.HALO;
                playBoard.getArray()[y3 + 1][x3 + 1] = BattlePiece.HALO;
                playBoard.getArray()[y3 + 1][x3] = BattlePiece.HALO;
                playBoard.getArray()[y3 + 1][x3 - 1] = BattlePiece.HALO;
                playBoard.getArray()[y3][x3 - 1] = BattlePiece.HALO;
                playBoard.getArray()[y2][x2 - 1] = BattlePiece.HALO;
                playBoard.getArray()[y1][x1 - 1] = BattlePiece.HALO;
            } else if (y2 < y1) {
                playBoard.getArray()[y1 + 1][x1 - 1] = BattlePiece.HALO;
                playBoard.getArray()[y1][x1 - 1] = BattlePiece.HALO;
                playBoard.getArray()[y2][x2 - 1] = BattlePiece.HALO;
                playBoard.getArray()[y3][x3 - 1] = BattlePiece.HALO;
                playBoard.getArray()[y3 - 1][x3 - 1] = BattlePiece.HALO;
                playBoard.getArray()[y3 - 1][x3] = BattlePiece.HALO;
                playBoard.getArray()[y3 - 1][x3 + 1] = BattlePiece.HALO;
                playBoard.getArray()[y3][x3 + 1] = BattlePiece.HALO;
                playBoard.getArray()[y2][x2 + 1] = BattlePiece.HALO;
                playBoard.getArray()[y1][x1 + 1] = BattlePiece.HALO;
                playBoard.getArray()[y1 + 1][x1 + 1] = BattlePiece.HALO;
                playBoard.getArray()[y1 + 1][x1] = BattlePiece.HALO;
            }
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Что-то с настройками ореола. Нужно проверить");
        }
    }

    public static boolean check09(int x, int y, PlayBoard playBoard) {
        if (0 > x | x > 9) {
            System.out.println("ввели неверные координаты x, введите числа от 0 до 9:");
            return false;
        }
        if (0 > y | y > 9) {
            System.out.println("ввели неверные координаты y, введите числа от 0 до 9:");
            return false;
        }
        if (playBoard.getArray()[y][x] != BattlePiece.EMPTY) {
            System.out.println("Место занято, введите новые координаты х,у:");
            return false;
        }
        return true;
    }

    public static boolean check09Baord(int x, int y) {
        if (0 > x | x > 9) {
            System.out.println("ввели неверные координаты x, введите числа от 0 до 9:");
            return false;
        }
        if (0 > y | y > 9) {
            System.out.println("ввели неверные координаты y, введите числа от 0 до 9:");
            return false;
        }
        return true;
    }

    public static boolean checkValid2(int x1, int y1, int x2, int y2) {
        if (x2 > x1 + 1 || x2 < x1 - 1) {
            System.out.println("ввели неверные координаты x не валиден");
            return false;
        }
        if (y2 > y1 + 1 || y2 < y1 - 1) {
            System.out.println("ввели неверные координаты y не валиден");
            return false;
        }
        return true;
    }

    public static boolean checkValid3(int x1, int y1, int x2, int y2, int x3, int y3) {
        if (x2 > x1 + 1 || x2 < x1 - 1 || x3 > x2 + 1 || x3 < x2 - 1) {
            System.out.println("ввели неверные координаты x не валиден");
            return false;
        }
        if (y2 > y1 + 1 || y2 < y1 - 1 || y3 > y2 + 1 || y3 < y2 - 1) {
            System.out.println("ввели неверные координаты y не валиден");
            return false;
        }
        return true;
    }

    public static boolean checkValid4(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
        if (x2 > x1 + 1 || x2 < x1 - 1 || x3 > x2 + 1 || x3 < x2 - 1) {
            System.out.println("ввели неверные координаты x не валиден");
            return false;
        }
        if (y2 > y1 + 1 || y2 < y1 - 1 || y3 > y2 + 1 || y3 < y2 - 1) {
            System.out.println("ввели неверные координаты y не валиден");
            return false;
        }
        return true;
    }

    public static boolean checkInt(String[] strings) {
        try {
            int x = Integer.parseInt(strings[0]);
            int y = Integer.parseInt(strings[1]);
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException r) {
            System.out.println("Введите координаты в формате x,y");
            return false;
        }
        if (strings.length > 2) {
            System.out.println("формат: х,у");
            return false;
        }
        return true;
    }

    public static boolean checkInt2(String[] strings) {
        try {
            int x = Integer.parseInt(strings[0]);
            int y = Integer.parseInt(strings[1]);
            int x2 = Integer.parseInt(strings[2]);
            int y2 = Integer.parseInt(strings[3]);
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException r) {
            System.out.println("Введите координаты в формате x,y");
            return false;
        }
        if (strings.length > 4) {
            System.out.println("формат: х,у;x,y");
            return false;
        }
        return true;
    }

    public static boolean checkInt3(String[] strings) {
        try {
            int x = Integer.parseInt(strings[0]);
            int y = Integer.parseInt(strings[1]);
            int x2 = Integer.parseInt(strings[2]);
            int y2 = Integer.parseInt(strings[3]);
            int x3 = Integer.parseInt(strings[4]);
            int y3 = Integer.parseInt(strings[5]);
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException r) {
            System.out.println("Введите координаты в формате x,y");
            return false;
        }
        if (strings.length > 6) {
            System.out.println("формат: х,у;x,y");
            return false;
        }
        return true;
    }

    public static boolean checkInt4(String[] strings) {
        try {
            int x = Integer.parseInt(strings[0]);
            int y = Integer.parseInt(strings[1]);
            int x2 = Integer.parseInt(strings[2]);
            int y2 = Integer.parseInt(strings[3]);
            int x3 = Integer.parseInt(strings[4]);
            int y3 = Integer.parseInt(strings[5]);
            int x4 = Integer.parseInt(strings[6]);
            int y4 = Integer.parseInt(strings[7]);
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException r) {
            System.out.println("Введите координаты в формате х,у;x,y;х,у;x,y");
            return false;
        }
        if (strings.length > 8) {
            System.out.println("формат: х,у;x,y;х,у;x,y");
            return false;
        }
        return true;
    }


    public static void playGame(PlayBoard playBoard1, PlayBoard playBoard2) {
        boolean i = true;
        int x = 0;
        int y = 0;
        String[] strings2 = null;
        boolean check1;
        boolean check2;
        do {
            System.out.println("стреляет 1 игрок по 2 полю");
            do {
                check1 = true;
                check2 = true;
                Scanner scanner = new Scanner(System.in);
                String strings = scanner.next();
                strings2 = strings.split(",");
                check2 = checkInt(strings2);
                if (check2 == true) {
                    x = Integer.parseInt(strings2[0]);
                    y = Integer.parseInt(strings2[1]);
                }
                check1 = check09Baord(x, y);
            } while (!check1 | !check2);

            if (playBoard2.getArray()[y][x] == BattlePiece.SHIP) {
                System.out.println("Попал!");
                playBoard2.getArray()[y][x] = BattlePiece.WRECKED;
                if (checkShip(playBoard1, x, y) == true) {
                    System.out.println("Ранил!");
                }
                if (checkShip(playBoard1, x, y) == false) {
                    System.out.println("Утопил!");
                }
                if (checkShipOnBoard(playBoard2) == false) {
                    System.out.println("Вы выйграли! Потопили все корабли!!! Game over!");
                    return;
                }
                ;
            } else {
                System.out.println("Мимо");
                i = false;
                break;
            }
        } while (true);


        boolean j = true;
        int x2 = 0;
        int y2 = 0;
        String[] strings3 = null;
        boolean check3;
        boolean check4;
        do {
            System.out.println("стреляет 2 игрок по 1 полю");
            do {
                check3 = true;
                check4 = true;
                Scanner scanner = new Scanner(System.in);
                String strings = scanner.next();
                strings3 = strings.split(",");
                check3 = checkInt(strings3);
                if (check3 == true) {
                    x2 = Integer.parseInt(strings3[0]);
                    y2 = Integer.parseInt(strings3[1]);
                }
                check4 = check09Baord(x2, y2);
            } while (!check3 | !check4);
            if (playBoard1.getArray()[y2][x2] == BattlePiece.SHIP) {
                System.out.println("Попал!");
                playBoard1.getArray()[y2][x2] = BattlePiece.WRECKED;
                if (checkShip(playBoard1, x2, y2) == true) {
                    System.out.println("Ранил!");
                }
                if (checkShip(playBoard1, x2, y2) == false) {
                    System.out.println("Утопил!");
                }
                if (checkShipOnBoard(playBoard1) == false) {
                    System.out.println("Вы выйграли! Потопили все корабли!!! Game over!");
                    return;
                }
                ;
            } else {
                System.out.println("Мимо");
                j = false;
                break;
            }
        } while (true);

        playGame(playBoard1, playBoard2);

    }

    public static boolean checkShipOnBoard(PlayBoard playBoard) {
        for (int i = 0; i < playBoard.getArray().length; i++) {
            for (int j = 0; j < playBoard.getArray().length; j++) {
                if (Arrays.asList(playBoard.getArray()[i][j]).contains(BattlePiece.SHIP)) return true;
            }
        }
        System.out.println("!!!!!!!!!!");
        return false;
    }

    public static boolean checkShip(PlayBoard playBoard, int x, int y) {
        try {if (playBoard.getArray()[y + 1][x] == BattlePiece.SHIP || playBoard.getArray()[y - 1][x] == BattlePiece.SHIP || playBoard.getArray()[y][x + 1] == BattlePiece.SHIP || playBoard.getArray()[y][x - 1] == BattlePiece.SHIP) {
            return true;
        }
    } catch (ArrayIndexOutOfBoundsException e){
            System.out.println("...");
        }
        return false;
    }


}

class PlayBoard {
    private final BattlePiece[][] array;

    public PlayBoard(BattlePiece[][] array) {
        this.array = array;
    }

    public BattlePiece[][] getArray() {
        return array;
    }


    public void print() {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                System.out.print(" " + array[i][j] + " ");
            }
            System.out.println();
        }
    }
}

class Player {
    private String name;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
