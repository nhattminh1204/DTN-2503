package service;

import models.User;

public interface UserService {
    boolean signUp(User user);
    boolean signIn(String email, String password);
}
