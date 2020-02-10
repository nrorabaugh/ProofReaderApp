package com.proofreader.server.Dao;

import com.proofreader.server.Entity.User;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class UserDao {

    public static Map<Integer, User> users;

    static {
        users = new HashMap<Integer, User>() {
            {
                put(1, new User("user1", "111", 1, 1, "teacher"));
                put(2, new User("user2", "222", 1, 2, "student"));
                put(3, new User("user3", "333", 1, 3, "student"));
                put(4, new User("user4", "444", 1, 4, "student"));
            }
        };
    }
    public Collection<User> getAllUsers() {
        return users.values();
    }

    public User getUserById(int id) {
        return users.get(id);
    }

    public void deleteUserById(int id) {
        users.remove(id);
    }

    public void updateUserById(User user) {
        User userToUpdate = users.get(user.getId());
        userToUpdate.setClassId(user.getClassId());
        userToUpdate.setUsername(user.getUsername());
        userToUpdate.setPassword(user.getPassword());
        userToUpdate.setRole(user.getRole());
        users.put(user.getId(), user);
    }

    public void addUser(User user) {
        users.put(user.getId(), user);
    }
}
