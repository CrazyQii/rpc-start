package top.hanlinqi.provider.service;

import top.hanlinqi.api.UserService;

/**
 * @program: UserServiceImpl
 * @description:
 * @author: hanLinQi
 * @create: 2023-03-08 14:22
 **/
public class UserServiceImpl implements UserService {

    @Override
    public String saveUserName(String username) {
        System.out.println("hello " + username);
        return username;
    }
}
