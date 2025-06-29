package Flyweight_2;

public class SharedCharacterStyle implements Character {
    private final String font;
    private final String color;
    private final int size;

    public SharedCharacterStyle(String font, String color, int size) {
        this.font = font;
        this.color = color;
        this.size = size;
    }

    @Override
    public void display(int x, int y, char symbol) {
        System.out.println("Ký tự '" + symbol + "' tại (" + x + ", " + y + ") | Font: " + font +
                ", Màu: " + color + ", Cỡ: " + size);
    }
}
