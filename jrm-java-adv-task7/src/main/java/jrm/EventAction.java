package jrm;

// уберите все лишнее и добавьте все необходимое, чтобы интерфейс стал функциональным
@FunctionalInterface
public interface EventAction {
    String makeAction();

    default void print() {
        System.out.println("Print");
    }
}
