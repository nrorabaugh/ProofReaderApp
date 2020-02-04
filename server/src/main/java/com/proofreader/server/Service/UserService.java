package com.proofreader.server.Service;

import com.proofreader.server.Dao.UserDao;
import com.proofreader.server.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public Collection<User> getAllUsers() {
        return this.userDao.getAllUsers();
    }

    public User getUserById(int id) {
        return this.userDao.getUserById(id);
    }

    public void deleteUserById(int id) {
        this.userDao.deleteUserById(id);
    }

    public void updateUserById(User user) {
        this.userDao.updateUserById(user);
    }

    public void addUser(User user) {
        this.userDao.addUser(user);
    }
}
