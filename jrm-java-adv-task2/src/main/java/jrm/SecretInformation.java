package jrm;

public class SecretInformation {

    private final String secretField = "секретный пароль";
    // с помощью рефлексии попробуйте добиться вызова данного метода
    private void getSecretInfo() {
        System.out.println(secretField);
    }
}