package jrm;

public class EventListener {
    public static void main(String[] args) {
// передать в параметры методу анонимный класс,который возвращает строку "Click at mouse button"
        EventAction eventListener = new EventAction() {
            @Override
            public String makeAction() {
                return "Click at mouse button";
            }
        };
        showEvent(eventListener);
    }


    private static void showEvent(EventAction action) {
        System.out.println(action.makeAction());
    }
}
