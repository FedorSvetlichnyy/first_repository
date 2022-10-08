package day13;

import java.util.ArrayList;
import java.util.Date;
import java.lang.Thread;
import java.util.List;

import static day13.MessageDatabase.addNewMessage;

public class Task1 {
    public static void main(String[] args) {
        User user1 = new User("User1");
        User user2 = new User("User2");
        User user3 = new User("User3");

        user1.sendMessage(user2, "������ ����2 �� ����1");
        user1.sendMessage(user2, "��� ���� ����2");
        user2.sendMessage(user1, "������ ����1 �� ����2");
        user2.sendMessage(user1, "��� ������ ����1");
        user2.sendMessage(user1, "�� �� ����1");
        user3.sendMessage(user1, "������ ����1 �� ����3");
        user3.sendMessage(user1, "���� ����1");
        user3.sendMessage(user1, "��� �� ����1");
        user1.sendMessage(user3, "������ ����3 �� ����1");
        user1.sendMessage(user3, "� ����� ����3");
        user1.sendMessage(user3, "�� ���� ����3");
        user3.sendMessage(user1, "��� ��������� ��������� ��� ����1");

        MessageDatabase.showDialog(user1, user3);

    }
}

class User {
    private String username;
    private List<User> subscriptions;
    public User(String username){
        this.username = username;
        this.subscriptions = new ArrayList<>();
    }
    public void subscribe(User user){
        subscriptions.add(user);
    }
    public boolean isSubscribed(User user){
        for (User x : getSubscriptions()) {
            if(user.equals(x.getSubscriptions()))
                return true;
        }
        return false;
    }
    public boolean isFriend(User user){
        for (User x : subscriptions) {
            if(user.equals(x.getSubscriptions()) & this.equals(x.getSubscriptions()))
                return true;
        }
        return false;
    }
    public void sendMessage(User user, String text){ //���������� ��������� � ������� text ������������ user. ����� ������ �������������� ����������� ����� �� MessageDatabase.
        addNewMessage(this, user, text);

    }
    public String toString(){ //���������� ��������� ������������� ������������ (��� ������������).
        return username;
    }

    public String getUsername() {
        return username;
    }
    public List<User> getSubscriptions() {
        return subscriptions;
    }


}
class Message {
    private User sender; //���� ���� User ������������� (����. sender) - ����������� ���������
    private User receiver; //���� ���� User ������������ (����. receiver) - ���������� ���������
    private String text; //��������� ���� ������ (����. text) - ����� ���������
    private Date date; //���� ���� Date ������ (����. date) - ���� �������� ���������

    public Message(User sender, User receiver, String text){
        this.sender = sender;
        this.receiver = receiver;
        this.text = text;
        this.date = new Date();
    }
    public String toString(){
        return "FROM: " + getSender() + "\n" +
        "TO: " + getReceiver() + "\n" +
        "ON: " + getDate() + "\n" + getText() + "\n";
    }

    public User getSender() {
        return sender;
    }

    public User getReceiver() {
        return receiver;
    }

    public String getText() {
        return text;
    }

    public Date getDate() {
        return date;
    }
}
class MessageDatabase {
    private static List<Message> messages = new ArrayList<>();
    public static void addNewMessage(User u1, User u2, String text){
        //���� ����� ����������� ����� ��������� �� ������������ u1 ������������ u2 � ������� text.
        // �������� � ����� ��������� �������� ���������� ��������� � ���� ����� �������
        messages.add(new Message(u1,u2,text));
    }

    public static List<Message> getMessages() {
        return messages; //���������� ������ ���� ��������� � ����� �������.
    }
    public static void showDialog(User u1, User u2) {
        for (Message x : getMessages()) {
            if (u1.equals(x.getSender()) & u2.equals(x.getReceiver())) {
                System.out.println(x.getSender() + ": " + x.getText());
            }
            if (u2.equals(x.getSender()) & u1.equals(x.getReceiver())) {
                System.out.println(x.getSender() + ": " + x.getText());
            }


        }
    }
}
