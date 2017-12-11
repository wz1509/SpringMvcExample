package me.wz;

import me.wz.entity.UserEntity;
import me.wz.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testQuery() throws Exception {
        dividingLine();
        List<UserEntity> users = userMapper.getUsers();
        for (UserEntity user : users) {
            System.out.println("getUsers --- >>> " + user.toString());
        }
        dividingLine();

        UserEntity user = userMapper.getUserId(8);
        System.out.println("getUser --->>> " + user.toString());
        dividingLine();

        List<UserEntity> list = userMapper.getUserUsername("18824910915");
        for (UserEntity entity : list) {
            System.out.println("getUser --- >>> " + entity.toString());
        }
        dividingLine();

//        userMapper.insertUser(new UserEntity("李玉刚","qwerty"));
//        System.out.println("添加成功");
//        dividingLine();

        user = new UserEntity();
        user.setId(9);
        user.setPassword("qwerty");
        userMapper.updateUser(user);
        System.out.println("更新成功");
        dividingLine();

        userMapper.deleteUser(14);
        System.out.println("删除成功");
        dividingLine();
    }

    private void dividingLine() {
        System.out.println("---------------华丽分割线---------------");
    }

}
