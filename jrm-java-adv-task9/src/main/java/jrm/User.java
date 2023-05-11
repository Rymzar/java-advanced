package jrm;

import java.util.function.Consumer;

public class User {
    private String name;
    private String email;

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
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
        Consumer<User> enrich = user ->
        {
            user.setEmail("ivan@mail.ru");
            user.setName("ivan");
        };
        System.out.println(mutate(enrich));

    }

    //передать такое выражение которое бы мутировало объект типа User
    //дообагащало его указанным в методе main именем(name) и почтой(email)
    public static User mutate(Consumer<User> mutation) {
        User user = new User();
        mutation.accept(user);
        return user;
    }
}