import java.util.*;
import java.util.Scanner;

public class Main {
    static Boolean abortOperations = false;
    static Scanner input = new Scanner(System.in);
    static HashMap<Integer, User> ourUsersDB = DataBase.DBUsers();
    static HashMap<Integer, Book> ourBooksDB = DataBase.DBBooks();

    private static boolean isUserInDb(int id, HashMap<Integer, User> ourUsersDB) throws IncorrectIDException {
        if (!ourUsersDB.containsKey(id)) {
            throw new IncorrectIDException("Некорректный id");
        } else {
            return true;
        }
    }
    public static void searchUserById(Scanner scanner) throws IncorrectIDException {
        System.out.println("Введите id искомого пользователя: ");
        int id = scanner.nextInt();
        if (isUserInDb(id, ourUsersDB)) {
            System.out.println("Пользователь " + ourUsersDB.get(id).getName() + " id = " + id + " был найден");
        } else {
            throw new IncorrectIDException("Incorrect entry please try again");
        }
    }
    public static void deleteUser(Scanner scanner) throws IncorrectIDException {
        System.out.println("Введите id пользователя для удаления: ");
        int userToDelete = scanner.nextInt();
        if (isUserInDb(userToDelete, ourUsersDB)) {
            System.out.println("Пользователь " + ourUsersDB.get(userToDelete).getName() + " id = " + userToDelete + " был удален");
            ourUsersDB.remove(userToDelete);
        } else {
            throw new IncorrectIDException("Incorrect id");
        }
    }

    public static void changeUser(Scanner scanner, HashMap<Integer, User> ourUsersDB) throws
            IncorrectIDException {
        System.out.println("Введите id пользователя");
        int id = scanner.nextInt();
        if (ourUsersDB.containsKey(id)) {
            System.out.println("\nПользователь с указанным id найден: " + ourUsersDB.get(id));
            System.out.println("\nУкажите данные, которые хотите изменить: \n* Изменить ФИО - введите 0 \n* Изменить пол - введите 1 \n* Изменить возраст - введите 2 \nYour entry >>");

            int command = scanner.nextInt();
            if (command == 0) {
                System.out.println("Введите новые ФИО");
                String newName = scanner.useDelimiter("\n").next();
                scanner.reset();
                String name = ourUsersDB.get(id).getName();
                ourUsersDB.get(id).setName(newName);
                System.out.println("У пользователя " + ourUsersDB.get(id) + " изменено имя. Было - " + name + ", стало - " + newName);
            } else if (command == 1) {
                System.out.println("Введите новый пол");
                String newGender = scanner.next();
                String gender = ourUsersDB.get(id).getGender();
                ourUsersDB.get(id).setGender(newGender);
                System.out.println("У пользователя " + ourUsersDB.get(id) + " изменен пол. Было - " + gender + ", стало - " + newGender);
            } else if (command == 2) {
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
        Integer randomBook = randomValue.nextInt(1, ourBooksDB.size());
        Integer randomUser = randomValue.nextInt(1, ourUsersDB.size());
        System.out.println(ourBooksDB.get(randomBook).name + " written by " + ourBooksDB.get(randomBook).author + " with id " + randomBook + " was taken by " + ourUsersDB.get(randomUser).getName() + " on " + ourBooksDB.get(randomBook).dateBorrowed + " and returned " + ourBooksDB.get(randomBook).dateReturned);
    }

    public static void showAllBooks() {
        System.out.println("Next books there are in the our library:");
        for (Map.Entry<Integer, Book> book : ourBooksDB.entrySet()) {
            System.out.println(book);
        }
    }

    public static void displayAllUsers(HashMap usersMap) {
        ArrayList<User> values = new ArrayList<>(usersMap.values());
        System.out.println("База данных пользователей библиотеки: " + "\n" + values);

    }

    public static ArrayList<String> getAllUsersNames() {
        ArrayList<String> allNames = new ArrayList<>();
        //for (int i = 1; i <= ourUsersDB.size(); i++) {
        for (int i = 1; i <= Collections.max(ourUsersDB.keySet()); i++) {
            if (ourUsersDB.get(i) == null) {
                continue;
            } else {
                allNames.add(ourUsersDB.get(i).getName());
            }
        }
        return allNames;
    }

    public static void createNewUser(Scanner scanner) throws IncorrectIDException {
        System.out.println("Введите имя нового пользователя: ");
        Integer id = 0;
        String newName = scanner.useDelimiter("\n").next();
        scanner.reset();
        try {
            getAllUsersNames();
            if (getAllUsersNames().contains(newName)) {
                throw new IncorrectIDException("Данный пользователь уже существует");
            } else {
                id = Collections.max(ourUsersDB.keySet()); //ourUsersDB.size();
                System.out.println("Введите пол нового пользователя: ");
                String newGender = scanner.next();
                System.out.println("Введите возраст нового пользователя: ");
                int newAge = scanner.nextInt();
                ourUsersDB.put(++id, new User(newName, newGender, newAge));
                System.out.println("Пользователь " + newName + " id = " + id + " создался в базе данных");
            }
        } catch (IncorrectIDException e) {
            throw new IncorrectIDException("Данный пользователь уже существует");
        }
    }

    public static void main(String[] args) throws IncorrectIDException {
        // To make the app infinite until we change abortOperations to false
        while (!abortOperations) {
            System.out.println("\nWelcome to our DataBase! Please let us know what would you like to do? \n* To check Users Database and display all users please enter 0 \n* To check all books in our Database please enter 1 \n* To Exit the app please enter 9 \nYour entry >>");
            int selectionOne = input.nextInt();

            if (selectionOne == 0) {
                System.out.println("You are now in our Users database. Please let us know what would you like to do: \n* To see all Users please enter 0\n* To search the user by id please enter 1 \n* To create new user please enter 2 \n* To change the existing user info please enter 3 \n* To delete the user by id please enter 4 \n* To return to main menu please enter 9 \nYour entry >>");
                int operation = input.nextInt();
                if (operation == 0) {
                    displayAllUsers(ourUsersDB);
                } else if (operation == 1) {
                    searchUserById(input);
                } else if (operation == 2) {
                    createNewUser(input);
                } else if (operation == 3) {
                    changeUser(input, ourUsersDB);
                } else if (operation == 4) {
                    deleteUser(input);
                } else if (operation == 9) {
                    System.out.println("Main Menu");
                } else {
                    throw new IncorrectIDException("Incorrect entry. please try again.");
                }
            } else if (selectionOne == 1) {
                System.out.println("You are now in our Books database. Please let us know what would you like to do? \n* To see the list of all Books please enter 0 \n* To find out a random entry in our database please enter 1 \n* to return to main menu please enter 9 \nYour entry >> ");
                int operation = input.nextInt();
                if (operation == 0) {
                    showAllBooks();
                } else if (operation == 1) {
                    displayRandom();
                } else if (operation == 9) {
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
