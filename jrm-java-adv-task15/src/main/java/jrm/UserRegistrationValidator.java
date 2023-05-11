package jrm;

import java.util.function.Function;

import static jrm.UserRegistrationValidator.ValidationResult.SUCCESS;


public interface UserRegistrationValidator extends Function<User, UserRegistrationValidator.ValidationResult> {

    static UserRegistrationValidator isEmailValid() {
        return user -> user.getEmail().contains("@") ? SUCCESS
                : ValidationResult.EMAIL_NOT_VALID;
    }

    static UserRegistrationValidator isPhoneNumberValid() {
        return user -> user.getPhoneNumber().startsWith("+7") ? SUCCESS
                : ValidationResult.PHONE_NUMBER_NOT_VALID;
    }

    default UserRegistrationValidator and(UserRegistrationValidator userRegistrationValidator) {
        return user -> {
            ValidationResult result = this.apply(user);
            return result.equals(SUCCESS) ? userRegistrationValidator.apply(user) : result;
        };
    }

    enum ValidationResult {
        SUCCESS,
        PHONE_NUMBER_NOT_VALID,
        EMAIL_NOT_VALID
    }
}
