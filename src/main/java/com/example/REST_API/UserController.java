package com.example.REST_API;
import java.util.*;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {

    private List<User> userList = new ArrayList<>();

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userList;
    }

    @PostMapping("/users")
    public String addUser(@RequestBody User user) {
        userList.add(user);
        return "user added successfully";
    }
    @PutMapping("/users/{id}")
    public String updateUser(@PathVariable int id, @RequestBody User user) {
        for (User u : userList) {
            if (u.getId() == id) {
                u.setName(user.getName());
                return "Data Updated Successfully";
            }
        }
        return "Detail not found!";
    }
    @DeleteMapping("/users/{id}")
    public String deleteUser(@PathVariable int id){
        userList.removeIf(user->user.getId()==id);
        return "Data deleted successfully";
    }
}
