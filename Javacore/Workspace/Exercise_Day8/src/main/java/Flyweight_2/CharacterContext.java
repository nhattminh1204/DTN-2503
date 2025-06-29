package Flyweight_2;

public class CharacterContext {
    private final int x;
    private final int y;
    private final char symbol;
    private final Character characterStyle;

    public CharacterContext(int x, int y, char symbol, Character characterStyle) {
        this.x = x;
        this.y = y;
        this.symbol = symbol;
        this.characterStyle = characterStyle;
    }

    public void render() {
        characterStyle.display(x, y, symbol);
    }
}
