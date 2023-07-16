package top.hanlinqi.api;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @program: UserService
 * @author: hanLinQi
 * @create: 2023-02-27 17:01
 **/
public interface UserService {

    /**
     * 保存用户名
     * @param username
     * @return
     */
    String saveUserName(String username);
}
