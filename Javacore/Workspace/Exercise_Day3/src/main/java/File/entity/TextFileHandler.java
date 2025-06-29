package File.entity;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class TextFileHandler extends FileHandler implements Encryptable {
    public TextFileHandler(String filePath) {
        super(filePath);
    }

    @Override
    public void read() throws IOException {
        System.out.print("Đọc file text: " + getFilePath());
        String content = Files.readString(Path.of(getFilePath()));
        System.out.println("Nội dung: ");
    }

    @Override
    public void write(String content) throws IOException {
        System.out.print("Ghi vào file text " + getFilePath());
        Files.writeString(Path.of(getFilePath()), content, StandardOpenOption.CREATE, StandardOpenOption.WRITE);
    }

    @Override
    public void delete() throws IOException {
        System.out.print("Xóa file text: " + getFilePath());
        Files.deleteIfExists(Path.of(getFilePath()));
    }


    @Override
    public void encrypt(String key) {
        System.out.println("Mã hóa file text với key: " + key);
    }

    @Override
    public void decrypt(String key) {
        System.out.println("Giải mã file text với key: " + key);
    }
}
