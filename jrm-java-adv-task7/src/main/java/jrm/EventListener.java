package jrm;

public class EventListener {
    public static void main(String[] args) {
// передать в параметры методу showEvent() лямбда выражение, которое возвращает строку "Click at mouse button"
        EventAction action = () -> "Click at mouse button";
        showEvent(action);
    }

    private static void showEvent(EventAction action) {
        System.out.println(action.makeAction());
    }
}
