package com.all.controller;


import com.all.controller.utils.Result;
import com.all.dao.UserDao;
import com.all.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user/api/v1")
public class UserController {

    @Autowired
    private UserDao userDao;

    @PostMapping("/login")
    public Result login(@RequestBody User user) {

        if (!checkParam(user)) {
            return new Result(false,"缺少必要参数");
        }
        User dbUser = userDao.selectByUsernameAndPassword(user);
        if (dbUser==null) {
            return new Result(false, "账号或密码错误");
        }
        return new Result(true,"成功");
    }

    private boolean checkParam(User user) {
        return user.getUsername()!=null && user.getPassword()!=null;
    }
}
