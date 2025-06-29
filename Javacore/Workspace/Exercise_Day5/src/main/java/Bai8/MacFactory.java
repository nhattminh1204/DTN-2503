package Bai8;

public class MacFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new MacButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new MacCheckbox();
    }

    @Override
    public Menu createMenu() {
        return new MacMenu();
    }

    @Override
    public Scrollbar createScrollbar() {
        return new MacScrollbar();
    }
}
