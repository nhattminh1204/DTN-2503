package File.entity;

public interface Encryptable {
    void encrypt(String key);
    void decrypt(String key);
}
