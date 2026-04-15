package com.example.TEST_API;
import java.util.*;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {

    private List<User>userList=new ArrayList<>();
    @GetMapping("/users")
    public List<User>getAllUsers(){
        return userList;
    }
    @PostMapping("/users")
    public String addUser(@RequestBody User user){
        userList.add(user);
        return "user added successfully";
    }

}
