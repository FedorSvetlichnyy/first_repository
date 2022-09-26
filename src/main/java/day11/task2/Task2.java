package day11.task2;

public class Task2 {
    public static void main(String[] args) {
        Warrior warrior =  new Warrior();
        Paladin paladin = new Paladin();
        Magician magician = new Magician();
        Shaman shaman = new Shaman();

        warrior.physicalAttack(paladin); //1. ���� ������� ��������
        System.out.println(paladin);
        paladin.physicalAttack(magician); //2. ������� ������� ����
        System.out.println(magician);
        shaman.healTeammate(magician); //3. ����� ����� ����
        System.out.println(magician);
        magician.magicalAttack(paladin); //4. ��� ������� ��������, ��� ����� �
        System.out.println(paladin);
        shaman.physicalAttack(warrior); //5. ����� ������� �����, ��� ����� �
        System.out.println(warrior);
        paladin.healHimself(); //6. ������� ����� ����
        System.out.println(paladin);
        System.out.println();
        for (int i = 0; i<5; i++) { //7. ���� ������� ���� 5 ���
            warrior.physicalAttack(magician);
            System.out.println(magician);
        }

    }
}
abstract class Hero{
    private int health;
    private boolean physDef; //���������� ���� ����� � - ���� ����� ��� ���
    private boolean magicDef; //���������� ��� ����� � - ���� ����� ��� ���

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
class Warrior extends Hero implements PhysAttack{ //����
    private int health = 100;
    private boolean physDef = false; // ���������� ���������� ����� ���
    public int getHealth() {
        return health;
    }
    public void setHealth(int health) {
        if(this.physDef == true){ //����������� ������ �� ���������� ����� 80%
            health = ((this.health - health)/10*8) + health;
            this.physDef = false; //���������� ���
        }
        if (health > 100) { //������������ �������� ������ ����� - 100, ����������� - 0.
            health = 100;
        }
        if (health < 0) {
            health = 0;
        }
        this.health = health;
    }

    @Override
    public void physicalAttack(Hero hero) { //���������� ����� �����
        hero.setPhysDef(true); //������ �������� ���������� �����, ����� ��������� ������ � �����, ���� ��� ����
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
class Paladin extends Hero implements PhysAttack, Healer{ //�������
    private int health = 100;
    private boolean physDef = false; // ���������� ���������� ����� ���
    private boolean magicDef = false; // ���������� ���������� ����� ���

    public int getHealth() {
        return health;
    }
    public void setHealth(int health) {
       if(this.physDef == true){ //����������� ������ �� ���������� ����� 50% (1/2)
           health = (this.health - health)/2 + health;
           this.physDef = false;
       }
        if(this.magicDef == true){ //����������� ������ �� ���������� ����� 20% (����� ����� �� 10 � �������� �� 8)
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
class Magician extends Hero implements MagicAttack{ //���
    private int health = 100;
    private boolean magicDef = false; // ���������� ���������� ����� ���

    public int getHealth() {
        return health;
    }
    public void setHealth(int health) {
        if(this.magicDef == true){ //����������� ������ �� ���������� ����� 80%
            health = ((this.health - health)/10*8) + health;
            this.magicDef = false; //���������� ���
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
        hero.setMagicDef(true); //������ �������� ���������� �����, ����� ��������� ������ � �����, ���� ��� ����
        hero.setHealth(hero.getHealth() - 20);
    }
    public void physicalAttack(Hero hero) {
        hero.setPhysDef(true); //������ �������� ���������� �����, ����� ��������� ������ � �����, ���� ��� ����
        hero.setHealth(hero.getHealth() - 5);
    }
    public boolean isMagicDef() {
        return magicDef;
    }

    public void setMagicDef(boolean magicDef) {
        this.magicDef = magicDef;
    }
}
class Shaman extends Hero implements Healer, PhysAttack{ //�����
    private int health = 100;
    private boolean physDef = false; // ���������� ���������� ����� ���
    private boolean magicDef = false; // ���������� ���������� ����� ���
    public int getHealth() {
        return health;
    }
    public void setHealth(int health) {
        if(this.physDef == true){ //����������� ������ �� ���������� ����� 20% (����� ����� �� 10 � �������� �� 8)
            health = this.health - ((this.health - health)/10*8);
            this.physDef = false;
        }
        if(this.magicDef == true){ //����������� ������ �� ���������� ����� 20% (����� ����� �� 10 � �������� �� 8)
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
        hero.setPhysDef(true); //������ �������� ���������� �����, ����� ��������� ������ � �����, ���� ��� ����
        hero.setHealth(hero.getHealth() - 10);
    }
    public void magicalAttack(Hero hero) {
        hero.setMagicDef(true); //������ �������� ���������� �����, ����� ��������� ������ � �����, ���� ��� ����
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
