package jrm;

import java.util.function.Function;

public class User {
    private String name;
    private String email;

    public User() {
    }

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public static void main(String[] args) {
        Function<Customer, User> exchange = client ->
                new User(client.getName(), client.getEmail());
        transform(exchange, new Customer("ivan", "ivan@mail.ru"));

    }

    public static void transform(Function<Customer, User> client, Customer customer) {
        System.out.println(client.apply(customer));
    }
}
