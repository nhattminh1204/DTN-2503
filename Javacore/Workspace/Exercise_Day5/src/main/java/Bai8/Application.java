package Bai8;

public class Application {
    private Button button;
    private Checkbox checkbox;
    private Menu menu;
    private Scrollbar scrollbar;

    public Application(GUIFactory factory) {
        button = factory.createButton();
        checkbox = factory.createCheckbox();
        menu = factory.createMenu();
        scrollbar = factory.createScrollbar();
    }

    public void renderUI() {
        button.paint();
        checkbox.paint();
        menu.show();
        scrollbar.scroll();
    }
}
