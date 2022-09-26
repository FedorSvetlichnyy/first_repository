package day11.task2;

public class Task2 {
    public static void main(String[] args) {
        Warrior warrior =  new Warrior();
        Paladin paladin = new Paladin();
        Magician magician = new Magician();
        Shaman shaman = new Shaman();

        warrior.physicalAttack(paladin); //1. Воин атакует Паладина
        System.out.println(paladin);
        paladin.physicalAttack(magician); //2. Паладин атакует Мага
        System.out.println(magician);
        shaman.healTeammate(magician); //3. Шаман лечит Мага
        System.out.println(magician);
        magician.magicalAttack(paladin); //4. Маг атакует Паладина, тип атаки М
        System.out.println(paladin);
        shaman.physicalAttack(warrior); //5. Шаман атакует Воина, тип атаки Ф
        System.out.println(warrior);
        paladin.healHimself(); //6. Паладин лечит себя
        System.out.println(paladin);
        System.out.println();
        for (int i = 0; i<5; i++) { //7. Воин атакует Мага 5 раз
            warrior.physicalAttack(magician);
            System.out.println(magician);
        }

    }
}
abstract class Hero{
    private int health;
    private boolean physDef; //переменная типа атаки Ф - есть атака или нет
    private boolean magicDef; //переменная тип атаки М - есть атака или нет

    public abstract String toString();

    public int getHealth(){
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public boolean isPhysDef() {
        return physDef;
    }

    public void setPhysDef(boolean physDef) {
        this.physDef = physDef;
    }

    public boolean isMagicDef() {
        return magicDef;
    }

    public void setMagicDef(boolean magicDef) {
        this.magicDef = magicDef;
    }
}
class Warrior extends Hero implements PhysAttack{ //Воин
    private int health = 100;
    private boolean physDef = false; // изначально физической атаки нет
    public int getHealth() {
        return health;
    }
    public void setHealth(int health) {
        if(this.physDef == true){ //срабатывает защита от физической атаки 80%
            health = ((this.health - health)/10*8) + health;
            this.physDef = false; //возвращаем тип
        }
        if (health > 100) { //Максимальное здоровье любого Героя - 100, минимальное - 0.
            health = 100;
        }
        if (health < 0) {
            health = 0;
        }
        this.health = health;
    }

    @Override
    public void physicalAttack(Hero hero) { //физическая атака героя
        hero.setPhysDef(true); //меняем значение физической атаки, чтобы сработала защита у героя, если она есть
        hero.setHealth(hero.getHealth() - 30);
    }
    public String toString(){
        return "Warrior{health=" + health + "}";
    }

    @Override
    public boolean isPhysDef() {
        return physDef;
    }

    @Override
    public void setPhysDef(boolean physDef) {
        this.physDef = physDef;
    }
}
class Paladin extends Hero implements PhysAttack, Healer{ //Паладин
    private int health = 100;
    private boolean physDef = false; // изначально физической атаки нет
    private boolean magicDef = false; // изначально магической атаки нет

    public int getHealth() {
        return health;
    }
    public void setHealth(int health) {
       if(this.physDef == true){ //срабатывает защита от физической атаки 50% (1/2)
           health = (this.health - health)/2 + health;
           this.physDef = false;
       }
        if(this.magicDef == true){ //срабатывает защита от магической атаки 20% (атаку делим на 10 и умножаем на 8)
            health = this.health - ((this.health - health)/10*8);
            this.magicDef = false;
        }
        if (health > 100) {
            health = 100;
        }
        if (health < 0) {
            health = 0;
        }
        this.health = health;
    }
    @Override
    public void physicalAttack(Hero hero) {
        hero.setHealth(hero.getHealth() - 15);
    }
    public String toString(){
        return "Paladin{health=" + health + "}";
    }

    @Override
    public void healHimself() {
        setHealth(getHealth() + 25);
    }

    @Override
    public void healTeammate(Hero hero) {
        hero.setHealth(hero.getHealth() + 10);
    }

    public boolean isPhysDef() {
        return physDef;
    }

    public void setPhysDef(boolean physDef) {
        this.physDef = physDef;
    }

    public boolean isMagicDef() {
        return magicDef;
    }

    public void setMagicDef(boolean magicDef) {
        this.magicDef = magicDef;
    }
}
class Magician extends Hero implements MagicAttack{ //Маг
    private int health = 100;
    private boolean magicDef = false; // изначально магической атаки нет

    public int getHealth() {
        return health;
    }
    public void setHealth(int health) {
        if(this.magicDef == true){ //срабатывает защита от физической атаки 80%
            health = ((this.health - health)/10*8) + health;
            this.magicDef = false; //возвращаем тип
        }
        if (health > 100) {
            health = 100;
        }
        if (health < 0) {
            health = 0;
        }
        this.health = health;
    }
    public String toString(){
        return "Magician{health=" + health + "}";
    }

    @Override
    public void magicalAttack(Hero hero) {
        hero.setMagicDef(true); //меняем значение магической атаки, чтобы сработала защита у героя, если она есть
        hero.setHealth(hero.getHealth() - 20);
    }
    public void physicalAttack(Hero hero) {
        hero.setPhysDef(true); //меняем значение физической атаки, чтобы сработала защита у героя, если она есть
        hero.setHealth(hero.getHealth() - 5);
    }
    public boolean isMagicDef() {
        return magicDef;
    }

    public void setMagicDef(boolean magicDef) {
        this.magicDef = magicDef;
    }
}
class Shaman extends Hero implements Healer, PhysAttack{ //Шаман
    private int health = 100;
    private boolean physDef = false; // изначально физической атаки нет
    private boolean magicDef = false; // изначально магической атаки нет
    public int getHealth() {
        return health;
    }
    public void setHealth(int health) {
        if(this.physDef == true){ //срабатывает защита от магической атаки 20% (атаку делим на 10 и умножаем на 8)
            health = this.health - ((this.health - health)/10*8);
            this.physDef = false;
        }
        if(this.magicDef == true){ //срабатывает защита от магической атаки 20% (атаку делим на 10 и умножаем на 8)
            health = this.health - ((this.health - health)/10*8);
            this.magicDef = false;
        }
        if (health > 100) {
            health = 100;
        }
        if (health < 0) {
            health = 0;
        }
        this.health = health;
    }
    public String toString(){
        return "Shaman{health=" + health + "}";
    }

    @Override
    public void healHimself() {
        setHealth(getHealth() + 50);
    }

    @Override
    public void healTeammate(Hero hero) {
        hero.setHealth(hero.getHealth() + 30);
    }

    @Override
    public void physicalAttack(Hero hero) {
        hero.setPhysDef(true); //меняем значение физической атаки, чтобы сработала защита у героя, если она есть
        hero.setHealth(hero.getHealth() - 10);
    }
    public void magicalAttack(Hero hero) {
        hero.setMagicDef(true); //меняем значение магической атаки, чтобы сработала защита у героя, если она есть
        hero.setHealth(hero.getHealth() - 15);
    }
    public boolean isPhysDef() {
        return physDef;
    }

    public void setPhysDef(boolean physDef) {
        this.physDef = physDef;
    }

    public boolean isMagicDef() {
        return magicDef;
    }

    public void setMagicDef(boolean magicDef) {
        this.magicDef = magicDef;
    }
}
