package jrm;

public class User {

    @JsonElement
    private String name;

    @JsonElement(key = "personAge")
    private String age;

    private String country;

    public User(String name, String age, String country) {
        this.name = name;
        this.age = age;
        this.country = country;
    }
}
