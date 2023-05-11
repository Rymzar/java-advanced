package jrm;


public class RegistrationUser {
    public static void main(String[] args) {
        User user = new User("+798787687", "ivan%mail.ru");
        UserRegistrationValidator.ValidationResult userRegistrationValidator =
                UserRegistrationValidator.isEmailValid()
                        .and(UserRegistrationValidator.isPhoneNumberValid())
                        .apply(user);

    }
}
