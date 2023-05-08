package jrm;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class App {

    public static void main(String[] args) {
        SecretInformation info = new SecretInformation();
        Method method = getMethodFromObject(info, "getSecretInfo");
        invoke(method, info);
    }


    // получить метод c помощью рефлексии
    public static Method getMethodFromObject(Object o, String nameOfMethod) {
        try {
            return o.getClass().getDeclaredMethod(nameOfMethod);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException();
        }
    }

    public static void invoke(Method method, SecretInformation info) {
        method.setAccessible(true);
        try {
            method.invoke(info);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
