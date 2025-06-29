package File.entity;

import java.io.IOException;

public abstract class FileHandler {
    private String filePath;

    public FileHandler(String filePath) {
        this.filePath = filePath;
    }

    public abstract void read() throws IOException;
    public abstract void write(String content) throws IOException;
    public abstract void delete() throws IOException;

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
