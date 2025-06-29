package File.entity;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class VideoFileHandler extends FileHandler implements Compressible, Encryptable{
    public VideoFileHandler(String filePath) {
        super(filePath);
    }

    @Override
    public void read() throws IOException {
        System.out.println("Đọc file video: " + getFilePath());
    }

    @Override
    public void write(String content) throws IOException {
        System.out.println("Ghi file video: " + getFilePath());
    }

    @Override
    public void delete() throws IOException {
        System.out.println("Xóa file video: " + getFilePath());
        Files.deleteIfExists(Path.of(getFilePath()));
    }

    @Override
    public void compress(String outputPath) {
        System.out.println("Nén video từ " + getFilePath() + " sang " + outputPath);
    }

    @Override
    public void decompress(String outputPath) {
        System.out.println("Giải nén video từ " + getFilePath() + " sang " + outputPath);
    }

    @Override
    public void encrypt(String key) {
        System.out.println("Mã hóa video với key: " + key);
    }

    @Override
    public void decrypt(String key) {
        System.out.println("Giải mã video với key: " + key);
    }
}
