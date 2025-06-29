package File.entity;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ImageFileHandler extends FileHandler implements Compressible{
    public ImageFileHandler(String filePath) {
        super(filePath);
    }

    @Override
    public void read() throws IOException {
        System.out.println("Đọc file ảnh: " + getFilePath());
    }

    @Override
    public void write(String content) throws IOException {
        System.out.println("Ghi file ảnh: " + getFilePath());
    }

    @Override
    public void delete() throws IOException {
        System.out.println("Xóa file ảnh: " + getFilePath());
        Files.deleteIfExists(Path.of(getFilePath()));
    }


    @Override
    public void compress(String outputPath) {
        System.out.println("Nén ảnh từ " + getFilePath() + " sang " + outputPath);
    }

    @Override
    public void decompress(String outputPath) {
        System.out.println("Giải nén ảnh từ " + getFilePath() + " sang " + outputPath);
    }

}
