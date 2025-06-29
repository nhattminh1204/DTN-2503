package Flyweight_2;
import java.util.HashMap;
import java.util.Map;

public class CharacterStyleFactory {
    private static final Map<String, SharedCharacterStyle> styles = new HashMap<>();

    public static Character getCharacterStyle(String font, String color, int size) {
        String key = font + "-" + color + "-" + size;
        if (!styles.containsKey(key)) {
            styles.put(key, new SharedCharacterStyle(font, color, size));
        }
        return styles.get(key);
    }
}
