package GameObject.entity;

public interface Fighter {
    void attack(Fighter target);
    boolean isAlive();
    void takeDamage(int damage);
    String getName();
    int getMana();
    int getBlood();
    int getMaxMana();
    int getMaxBlood();
    void recover(); // Hồi mana nhẹ sau mỗi lượt
}
