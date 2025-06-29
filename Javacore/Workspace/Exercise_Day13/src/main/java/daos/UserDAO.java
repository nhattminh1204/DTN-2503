package daos;

import models.User;

import java.util.List;

public interface UserDAO {
    User findByEmail(String email);
    boolean save(User user);
    List<User> searchByName(String keyword);
    boolean updatePassword(String email, String newPassword);
    boolean deleteByEmail(String email);
    List<User> findAll();
}
