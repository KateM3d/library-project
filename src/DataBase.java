import java.util.HashMap;

public class DataBase {

    public static HashMap<Integer,User> DBUsers() {

        Integer id = 0;
        HashMap<Integer, User> userMap = new HashMap<>();

        userMap.put(++id, new User("Герасимов Дмитрий Олегович", "мужской", 25));
        userMap.put(++id, new User("Зиновьев Станислав Александрович", "мужской", 27));
        userMap.put(++id, new User("Стариков Дмитрий Андреевич", "мужской", 34));
        userMap.put(++id, new User("Макарова Александра Игоревна", "женский", 18));
        userMap.put(++id, new User("Чернопятова Анна Андреевна", "женский", 12));

        userMap.put(++id, new User("Сидоров Иван Алексеевич", "мужской", 29));
        userMap.put(++id, new User("Маркина Дарья Вячеславовна", "женский", 48));
        userMap.put(++id, new User("Новиков Виктор Петрович", "мужской", 31));
        userMap.put(++id, new User("Харламов Андрей Дмитриевич", "мужской", 11));
        userMap.put(++id, new User("Иванов Иван Иванович", "мужской", 17));

        userMap.put(++id, new User("Белоусова Татьяна Олеговна", "женский", 25));
        userMap.put(++id, new User("Гончарова Алина Алексеевна", "женский", 36));
        userMap.put(++id, new User("Грибанов Роман Станиславович", "мужской", 64));
        userMap.put(++id, new User("Петрова Анастасия Николаевна", "женский", 23));
        userMap.put(++id, new User("Печурин Николай Николаевич", "мужской", 19));

        userMap.put(++id, new User("Романов Максим Игоревич", "мужской", 43));
        userMap.put(++id, new User("Бабушкин Игорь Александрович", "мужской", 17));
        userMap.put(++id, new User("Пятчанин Иван Владимирович", "мужской", 59));
        userMap.put(++id, new User("Петров Петр Петрович", "мужской", 46));
        userMap.put(++id, new User("Зуева Людмила Николаевна", "женский", 39));

        return userMap;

    }

}
