package com.proofreader.server.Controller;

import com.proofreader.server.Entity.User;
import com.proofreader.server.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public List<User> getUserById(@PathVariable("id") int id) {
        return userService.getUserById(id);
    }

    @RequestMapping(value = "/username:{username}/password:{password}", method = RequestMethod.GET)
    public List<User> getUserByCred(@PathVariable("username") String username, @PathVariable("password") String password) {
        return userService.getUserByCred(username, password);
    }

    @RequestMapping(value = "/extant/{username}", method = RequestMethod.GET)
    public List<User> getUsername(@PathVariable("username") String username) {
        return userService.getUsername(username);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteUserById(@PathVariable("id") int id) {
        userService.deleteUserById(id);
    }

    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateUserById(@RequestBody User user) {
        userService.updateUserById(user);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addUser(@RequestBody User user){
        userService.addUser(user);
    }
}
