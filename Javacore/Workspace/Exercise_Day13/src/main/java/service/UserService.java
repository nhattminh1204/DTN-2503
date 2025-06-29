package service;

import models.User;
import java.util.List;

public interface UserService {
    boolean register(User user);
    User login(String email, String password);
    boolean changePassword(String email, String oldPass, String newPass);
    List<User> searchUser(String keyword);
    List<User> getAllUsers();
    boolean deleteUser(String email);
}