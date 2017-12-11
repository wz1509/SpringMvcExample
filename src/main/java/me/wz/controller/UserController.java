package me.wz.controller;

import me.wz.entity.UserEntity;
import me.wz.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


//@RestController 的意思就是controller里面的方法都以json格式输出，不用再写什么jackjson配置的了！
@RestController
public class UserController {

    @Autowired
    public UserMapper userMapper;

    @RequestMapping("/")
    public ResponseEntity index() {
        return ResponseEntity.ok().body("Hello World");
    }

    @RequestMapping("/hello")
    public String hello() {
        return "Hello World";
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserEntity>> getUsers() {
        return ResponseEntity.ok().body(userMapper.getUsers());
    }

    @GetMapping("/user/id/{id}")
    public ResponseEntity<UserEntity> getUserId(@PathVariable("id") int id) {
        return ResponseEntity.ok().body(userMapper.getUserId(id));
    }

    @GetMapping("/user/username/{username}")
    public ResponseEntity<List<UserEntity>> getUserUsername(@PathVariable("username") String username) {
        return ResponseEntity.ok().body(userMapper.getUserUsername(username));
    }

    // 请求方式如：http://localhost:8080/user/add?username=%E9%83%91%E7%88%BD&password=123321
    @GetMapping("/user/add")
    public ResponseEntity<String> insertUser(String username, String password) {
        userMapper.insertUser(new UserEntity(username, password));
        return ResponseEntity.ok().body("添加成功");
    }




}
