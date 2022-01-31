package com.example.demo.service;

import com.example.demo.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class User_Service {

    private List<User> userList = new ArrayList<>(
            Arrays.asList(
                    new User(1, "Ivan", "Ivanov", "89276150413"),
                    new User(2, "Sregey", "Sergeev", "89276150413"),
                    new User(3, "Dmitry", "Dmitriev", "89276150413")
            )
    );

    public List<User> getUsers() {
        return userList;
    }

    public User get_User_By_Id(int id) {
        return userList.stream().filter(user -> user.getId() == id).findFirst().get();
    }

    public User create_User(User newUser) {
        User lastuser = userList.isEmpty() ? null : userList.get(userList.size() - 1);
        newUser.setId(lastuser.getId() + 1);
        userList.add(newUser);
        return newUser;
    }

    public User delete_User(User delete_user){
        User lastUser = userList.isEmpty() ? null : userList.get(userList.size() - 1);
        delete_user.setId(lastUser.getId());
        userList.remove(delete_user);
        return delete_user;
    }

    public User put_User(User put_User){
        User lastUser = userList.isEmpty() ? null : userList.get(userList.size() - 1);
        put_User.setName("Vladislav");
        put_User.setLastname("Vladislavovich");
        put_User.setMobile("89272342156");
        return put_User;
    }

}