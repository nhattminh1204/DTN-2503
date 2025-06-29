package AbstractFactory;

public class Main {
    public static void main(String[] args) {
        System.out.println("\nCreate LightTheme element");
        UIFactory lightFactory = new LightThemeFactory();
        Button lightButton = new LightButton();
        TextField lightTextField = new LightTextField();

        lightButton.render();
        lightTextField.render();

        System.out.println("\nCreate DarkTheme element");
        UIFactory darkFactory = new DarkThemeFactory();
        Button darkButton = new DarkButton();
        TextField darkTextField = new DarkTextField();

        darkButton.render();
        darkTextField.render();
    }
}
