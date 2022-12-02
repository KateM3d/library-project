import java.security.PublicKey;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void ChangeUser(HashMap usersMap) {

        System.out.println("Введите id пользователя");
        Scanner inputId = new Scanner(System.in);
        int id = inputId.nextInt();

        if (usersMap.containsKey(id)) {
            System.out.println("Пользователь с указанным id найден: " + usersMap.get(id));
            HashMap<Integer,User> ourDB = usersMap;

            System.out.println("Укажите данные, которые хотите изменить:");
            System.out.println("Изменить ФИО - введите 1");
            System.out.println("Изменить пол - введите 2");
            System.out.println("Изменить возраст - введите 3");

            Scanner inputCommand = new Scanner(System.in);
            int command = inputCommand.nextInt();

            if (command == 1) {
                System.out.println("Введите новые ФИО");
                Scanner inputName = new Scanner(System.in);
                String newName = inputName.nextLine();

                String name = ourDB.get(id).getName();
                ourDB.get(id).setName(newName);
                System.out.println("У пользователя " + ourDB.get(id) + " изменено имя. Было - " + name + ", стало - " + newName);
            }
            else if (command == 2) {
                System.out.println("Введите новый пол");
                Scanner inputGender = new Scanner(System.in);
                String newGender = inputGender.nextLine();

                String gender = ourDB.get(id).getGender();
                ourDB.get(id).setGender(newGender);
                System.out.println("У пользователя " + ourDB.get(id) + " изменен пол. Было - " + gender + ", стало - " + newGender);
            }
            else if (command == 3) {
                System.out.println("Введите новый возраст");
                Scanner inputAge = new Scanner(System.in);
                int newAge = inputAge.nextInt();

                int age = ourDB.get(id).getAge();
                ourDB.get(id).setAge(newAge);
                System.out.println("У пользователя " + ourDB.get(id) + " изменен возраст. Было - " + age + ", стало - " + newAge);
            }

        } else {
            System.out.println("Не найден пользователь с указанным id!");
        }
    }

    public static void main(String[] args) {
        System.out.println("Hello world!");

        HashMap usersMap = new DataBase().DBUsers();

        System.out.println("Если вы хотите изменить данные о пользователе, введите 2");
        Scanner inputCommand = new Scanner(System.in);
        int command = inputCommand.nextInt();

        if (command == 2) {
            ChangeUser(usersMap);
        }

    }
}