package jrm;

import java.util.function.Predicate;

public class User {
    private String name;
    private String email;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public static void main(String[] args) {
        // написать такое выражение типа Predicate, которое поможет методу validate
        // валидировать корректность заполнения email у объекта типа User.
        // Необходимо определить: находится ли в email служебный символ "@",
        // если нет, тогда метод validate должен выбросить исключение
        Predicate<User> validatorExpression = user -> user.getEmail().contains("@");
        validate(validatorExpression, new User("ivan", "ivan.mail.ru"));
    }

    public static User validate(Predicate<User> mutation, User user) {
        if (mutation.test(user)) {
            return user;
        } else {
            throw new IllegalArgumentException();
        }
    }
}
