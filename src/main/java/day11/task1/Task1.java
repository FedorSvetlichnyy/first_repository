package day11.task1;

import static day11.task1.Warehouse.*;

public class Task1 {
    public static void main(String[] args) {
        Warehouse warehouse1 = new Warehouse(); //создали склад 1
        Picker picker1 = new Picker(warehouse1); //создали сборщика 1
        Courier courier1 = new Courier(warehouse1); //создали курьера 1

        businessProcess(picker1);
        System.out.println(picker1);
        System.out.println(warehouse1);
        System.out.println(courier1);
        businessProcess(courier1);
        System.out.println(courier1);
        System.out.println(warehouse1);

        Warehouse warehouse2 = new Warehouse(); //создали склад 2
        Courier courier2 = new Courier(warehouse2); //создали курьера 2
        Picker picker2 = new Picker(warehouse2); //создали сборщика 2
        picker2.doWork();
        courier2.doWork();

        System.out.println(picker1);
        System.out.println(warehouse1);
        System.out.println(courier1);

    }

    private static void businessProcess(Worker worker) {
        for(int i = 1; i<=10000; i++){
            worker.doWork();
        }
        worker.bonus();
    }
}
class Warehouse{
    static int countPickedOrders;
    static int countDeliveredOrders;
    public String toString(){
       return "Количество собранных заказов склада " + " = " + getCountPickedOrders() + ", " + "количество доставленных заказов " + getCountDeliveredOrders() + ".";
    }

    public static void setCountPickedOrders() {
        countPickedOrders++;
    }

    public static void setCountDeliveredOrders() {
        countDeliveredOrders++;
    }

    public static int getCountPickedOrders() {
       return countPickedOrders;
    }

    public static int getCountDeliveredOrders() {
        return countDeliveredOrders;
    }
}
class Picker implements Worker{
    private int salary;
    private int isPayed;
    private Warehouse warehouse;

    public int getSalary() {
        return salary;
    }

    public int getIsPayed() {
        return isPayed;
    }
    public Picker(Warehouse warehouse){
        this.warehouse = warehouse;

    }
    public String toString(){
        return "Заработная плата сборщика " + getSalary() + ", " + "был выплачен бонус или нет " + getIsPayed() + ".";
    }

    @Override
    public void bonus() {
        if(warehouse.getCountPickedOrders() >= 10000){
            isPayed = isPayed + 70000;
        } else {
            System.out.println("Бонус пока не доступен");
        }
        if(isPayed > 0){
            System.out.println("Бонус уже был выплачен");
        }
    }

    @Override
    public void doWork() {
        salary = salary + 80;
        warehouse.setCountPickedOrders(); //увеличение собранного заказа на 1
        }
}
class Courier implements Worker{
    private int salary;
    private int isPayed;

    public int getSalary() {
        return salary;
    }

    public int getIsPayed() {
        return isPayed;
    }
    public Courier(Warehouse warehouse){

    }
    public String toString(){
       return "Заработная плата курьера " + getSalary() + ", " + "был выплачен бонус или нет " + getIsPayed() + ".";
    }

    @Override
    public void bonus() {
        if(countDeliveredOrders >= 10000){
            isPayed = isPayed + 50000;
        } else {
            System.out.println("Бонус пока не доступен");
        }
        if(isPayed > 0){
            System.out.println("Бонус уже был выплачен");
        }
    }

    @Override
    public void doWork() {
        salary = salary + 100;
        setCountDeliveredOrders();
        //System.out.println("Поработали, доставили товар");
    }
}

