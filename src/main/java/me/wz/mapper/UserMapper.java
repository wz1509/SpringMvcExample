package me.wz.mapper;

import me.wz.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    List<UserEntity> getUsers();

    UserEntity getUserId(int id);

    List<UserEntity> getUserUsername(String username);

    void insertUser(UserEntity user);

    void updateUser(UserEntity user);

    void deleteUser(int id);

}
