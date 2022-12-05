import java.util.*;
import java.util.Scanner;

public class Main {
    static Boolean abortOperations = false;
    static Scanner input = new Scanner(System.in);
    static HashMap<Integer, User> ourUsersDB = new DataBase().DBUsers();
    static HashMap<Integer, Book> ourBooksDB = new DataBase().DBBooks();


    private static void findUserByID(int id, HashMap<Integer, User> ourUsersDB) throws IncorrectIDException {
        /*В методе выведите в консоль информацию о том, какого юзера метод нашел. Например: “Пользователь Иван Петров id=2 был найден”;*/
        if (!ourUsersDB.containsKey(id)) {
            throw new IncorrectIDException("Некорректный id");
        } else {
            System.out.println("Пользователь " + ourUsersDB.get(id).getName() + " id = " + id + " был найден");
        }
    }

    public static void searchUserById(Scanner scanner) throws IncorrectIDException {
        System.out.println("Введите id искомого пользователя: ");
        int id = scanner.nextInt();
        try {
            findUserByID(id, ourUsersDB);
        } catch (IncorrectIDException e) {
            throw new IncorrectIDException("Incorrect entry please try again");
        }
    }

    private static void deleteUserByID(int id, HashMap<Integer, User> ourUsersDB) throws IncorrectIDException {
        /*В методе выведите в консоль информацию о том, какого юзера метод удалил. Например: “Пользователь Иван Петров был удален по id=2”*/
        if (!ourUsersDB.containsKey(id)) {
            throw new IncorrectIDException("Некорректный id");
        } else {
            System.out.println("Пользователь " + ourUsersDB.get(id).getName() + " id = " + id + " был удален");
            ourUsersDB.remove(id);
        }
    }

    public static void deleteUser(Scanner scanner) throws IncorrectIDException {
        System.out.println("Введите id пользователя для удаления: ");

        int userToDelete = scanner.nextInt();
        try {
            deleteUserByID(userToDelete, ourUsersDB);
        } catch (IncorrectIDException e) {
            throw new IncorrectIDException("Incorrect id");
        }
    }

    public static void changeUser(Scanner scanner, HashMap<Integer, User> ourUsersDB) throws IncorrectIDException {
        System.out.println("Введите id пользователя");
        int id = scanner.nextInt();

        if (ourUsersDB.containsKey(id)) {
            System.out.println("Пользователь с указанным id найден: " + ourUsersDB.get(id));
            System.out.println("Укажите данные, которые хотите изменить:");
            System.out.println("* Изменить ФИО - введите 1");
            System.out.println("* Изменить пол - введите 2");
            System.out.println("* Изменить возраст - введите 3");
            System.out.println("Your entry >>");

            int command = scanner.nextInt();

            if (command == 1) {
                System.out.println("Введите новые ФИО");
                String newName = scanner.next();
                String name = ourUsersDB.get(id).getName();
                ourUsersDB.get(id).setName(newName);
                System.out.println("У пользователя " + ourUsersDB.get(id) + " изменено имя. Было - " + name + ", стало - " + newName);
            } else if (command == 2) {
                System.out.println("Введите новый пол");
                String newGender = scanner.next();
                String gender = ourUsersDB.get(id).getGender();
                ourUsersDB.get(id).setGender(newGender);
                System.out.println("У пользователя " + ourUsersDB.get(id) + " изменен пол. Было - " + gender + ", стало - " + newGender);
            } else if (command == 3) {
                System.out.println("Введите новый возраст");
                int newAge = scanner.nextInt();
                int age = ourUsersDB.get(id).getAge();
                ourUsersDB.get(id).setAge(newAge);
                System.out.println("У пользователя " + ourUsersDB.get(id) + " изменен возраст. Было - " + age + ", стало - " + newAge);
            }
        } else {
            throw new IncorrectIDException("Не найден пользователь с указанным id!");
        }
    }

    public static void displayRandom() {
        Random randomValue = new Random();
        // TODO: change randomBook to 21 once all books entered
        Integer randomBook = randomValue.nextInt(1, 8);
        Integer randomUser = randomValue.nextInt(1, 21);
        System.out.println(ourBooksDB.get(randomBook).name + " written by " + ourBooksDB.get(randomBook).author + " with id " + randomBook + " was taken by " + ourUsersDB.get(randomUser).getName() + " on " + ourBooksDB.get(randomBook).dateBorrowed + " and returned " + ourBooksDB.get(randomBook).dateReturned);
    }

    public static void main(String[] args) throws IncorrectIDException {
        // To make the app infinite until we change abortOperations to false
        while (!abortOperations) {
            System.out.println("Welcome to our DataBase! Please let us know what would you like to do?");
            System.out.println("* To check Users Database and display all users please enter 1");
            System.out.println("* To check all books in our Database please enter 2");
            System.out.println("* To Exit the app please enter 9");
            System.out.println("Your entry >>");

            int selectionOne = input.nextInt();

            if (selectionOne == 1) {
                System.out.println("You are now in our Users database. Please let us know what would you like to do:");
                System.out.println("* To see all Users please enter 0");
                System.out.println("* To search the user by id please enter 1");
                System.out.println("* To create new user please enter 2");
                System.out.println("* To change the existing user info please enter 3");
                System.out.println("* To delete the user by id please enter 4");
                System.out.println("* To return to main menu please enter 5");
                System.out.println("Your entry >>");

                int operation = input.nextInt();

                if (operation == 0) {
                    // Show all users
                    System.out.println("Show all users");
                    // TODO: showAllUsers();
                } else if (operation == 1) {
                    searchUserById(input);
                } else if (operation == 2) {
                    // Create new User
                    System.out.println("create new user flow");
                    // TODO: createNewUser();
                } else if (operation == 3) {
                    // Change data
                    changeUser(input, ourUsersDB);
                } else if (operation == 4) {
                    // Delete User
                    deleteUser(input);
                } else if (operation == 5) {
                    // Return to Main Menu
                    System.out.println("Main Menu");
                } else {
                    throw new IncorrectIDException("Incorrect entry. please try again.");
                }
            } else if (selectionOne == 2) {
                System.out.println("You are now in our Books database. Please let us know what would you like to do?");
                System.out.println("* To see the list of all Books please enter 0");
                System.out.println("* To find out a random entry in our database please enter 1");
                System.out.println("* to return to main menu please enter 2");
                System.out.println("Your entry >>");

                int operation = input.nextInt();

                if (operation == 0) {
                    // Method to show all books
                    System.out.println("all books");
                    // TODO: showAllBooks();
                } else if (operation == 1) {
                    // Method to show random book + random user
                    displayRandom();
                } else if (operation == 2) {
                    // Return to main menu
                    System.out.println("Main Menu");
                } else {
                    throw new IncorrectIDException("Incorrect entry. Please try again.");
                }
            } else if (selectionOne == 9) {
                // Stop application once user select 9
                abortOperations = true;
            } else {
                throw new IncorrectIDException("Incorrect entry. Please try again.");
            }
        }
    }
}