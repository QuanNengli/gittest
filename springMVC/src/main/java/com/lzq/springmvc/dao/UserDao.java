package com.lzq.springmvc.dao;

import com.lzq.springmvc.bean.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDao {
    private static List<User> userList=new ArrayList<User>();
    static {
        User user1 = new User(1001L, "张三", 1, "zhangsan@qq.com");
        User user2 = new User(1002L, "李四", 1, "lisi@qq.com");
        User user3 = new User(1003L, "王五", 0, "wangwu@qq.com");
        User user4 = new User(1004L, "孙悟空", 1, "sunwukong@qq.com");
        User user5 = new User(1005L, "武松", 1, "wusong@qq.com");
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        userList.add(user4);
        userList.add(user5);

    }
    public Long getId(){
        Long a=0L;
        for (User user : userList) {
            if (user.getId()>a) {
                a=user.getId();
            }
        }
        return (Long)(a+1);
    }
    public List<User> selectAll(){
        return userList;
    }
    public void insert(User user){
        User user1 = new User(getId(), user.getUsername(), user.getSex(), user.getEmail());
        userList.add(user1);
    }
    public User getUserById(Long id){


        for (User user : userList) {
            if (user.getId().equals(id)) {
                return user;
            }
        }
        return null;

    }
    public void update(User user){
        for(int i=0;i<userList.size();i++){
            if (userList.get(i).getId().equals(user.getId())) {
                userList.set(i,user);
                return;
            }
        }
    }
    public void deleteById(Long id ){
        for (int i=0;i<userList.size();i++){
            if (userList.get(i).getId().equals(id)) {
                userList.remove(i);
                return;
            }

        }
    }

}
