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

        user1.sendMessage(user2, "Привет юзер2 от юзер1");
        user1.sendMessage(user2, "Как дела юзер2");
        user2.sendMessage(user1, "Привет юзер1 от юзер2");
        user2.sendMessage(user1, "Все хорошо юзер1");
        user2.sendMessage(user1, "Ты же юзер1");
        user3.sendMessage(user1, "Привет юзер1 от юзер3");
        user3.sendMessage(user1, "Пишу юзер1");
        user3.sendMessage(user1, "Как ты юзер1");
        user1.sendMessage(user3, "Привет юзер3 от юзер1");
        user1.sendMessage(user3, "Я читаю юзер3");
        user1.sendMessage(user3, "Ты пиши юзер3");
        user3.sendMessage(user1, "Это последнее сообщение для юзер1");

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
    public void sendMessage(User user, String text){ //отправляет сообщение с текстом text пользователю user. Здесь должен использоваться статический метод из MessageDatabase.
        addNewMessage(this, user, text);

    }
    public String toString(){ //возвращает строковое представление пользователя (имя пользователя).
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
    private User sender; //Поле типа User “отправитель” (англ. sender) - отправитель сообщения
    private User receiver; //Поле типа User “получатель” (англ. receiver) - получатель сообщения
    private String text; //Строковое поле “текст” (англ. text) - текст сообщения
    private Date date; //Поле типа Date “дата” (англ. date) - дата отправки сообщения

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
        //этот метод “отправляет” новое сообщение от пользователя u1 пользователю u2 с текстом text.
        // Отправка в нашем контексте означает добавление сообщения в нашу “базу данных”
        messages.add(new Message(u1,u2,text));
    }

    public static List<Message> getMessages() {
        return messages; //возвращает список всех сообщений в “базе данных”.
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
