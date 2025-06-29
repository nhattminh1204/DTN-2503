package service;

import daos.UserDAO;
import models.User;
import utils.HashUtil;

import java.util.List;

public class UserServiceImpl implements UserService {
    private final UserDAO userDAO;

    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public boolean register(User user) {
        if (userDAO.findByEmail(user.getEmail()) == null) {
            user.setPassword(HashUtil.hashPassword(user.getPassword(), "SHA-512"));
            return userDAO.save(user);
        }
        return false;
    }

    @Override
    public User login(String email, String password) {
        User user = userDAO.findByEmail(email);
        if (user != null) {
            String hash = HashUtil.hashPassword(password, "SHA-512");
            if (user.getPassword().equals(hash)) return user;
        }
        return null;
    }

    @Override
    public boolean changePassword(String email, String oldPass, String newPass) {
        User user = userDAO.findByEmail(email);
        if (user == null) return false;

        String hashedOld = HashUtil.hashPassword(oldPass, "SHA-512");
        if (!hashedOld.equals(user.getPassword())) return false;

        String hashedNew = HashUtil.hashPassword(newPass, "SHA-512");
        if (hashedNew.equals(user.getPassword())) return false;

        return userDAO.updatePassword(email, newPass);
    }

    @Override
    public List<User> searchUser(String keyword) {
        return userDAO.searchByName(keyword);
    }

    @Override
    public List<User> getAllUsers() {
        return userDAO.findAll();
    }

    @Override
    public boolean deleteUser(String email) {
        return userDAO.deleteByEmail(email);
    }
}