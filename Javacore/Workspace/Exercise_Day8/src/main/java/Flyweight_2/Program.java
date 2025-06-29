package Flyweight_2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Program {
    public static void main(String[] args) {
        List<CharacterContext> document = new ArrayList<>();
        Random random = new Random();

        Character styleThuong = CharacterStyleFactory.getCharacterStyle("Arial", "Đen", 12);
        Character styleHoa = CharacterStyleFactory.getCharacterStyle("Times New Roman", "Xanh", 14);

        String text = "Flyweight Pattern";

        for (int i = 0; i < text.length(); i++) {
            int x = i * 10;
            int y = random.nextInt(20);
            char symbol = text.charAt(i);

            Character style = java.lang.Character.isUpperCase(symbol) ? styleHoa : styleThuong;

            document.add(new CharacterContext(x, y, symbol, style));
        }

        // In ra màn hình
        System.out.println("📝 Hiển thị văn bản:");
        for (CharacterContext ch : document) {
            ch.render();
        }
    }
}

