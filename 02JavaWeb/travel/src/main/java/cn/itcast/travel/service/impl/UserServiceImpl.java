package cn.itcast.travel.service.impl;

import cn.itcast.travel.dao.UserDao;
import cn.itcast.travel.dao.impl.UserDaoImpl;
import cn.itcast.travel.domain.User;
import cn.itcast.travel.service.UserService;
import cn.itcast.travel.util.MailUtils;

import java.util.UUID;

public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();



    @Override
    public boolean registerUser(User user) {
        //根据用户名查找对象
        User userObj = userDao.findByUsername(user.getUsername());
        if (userObj != null){
            return false;
        }

        //保存用户数据
        user.setStatus("N");
        user.setCode(String.valueOf(UUID.randomUUID()));
        userDao.save(user);

        //发送激活邮件
        String content="<a href='http://localhost/travel/user/active?code="+user.getCode()+"'>点击激活【黑马旅游网】</a>";
        MailUtils.sendMail(user.getEmail(), content, "激活邮件");
        return true;
    }

    @Override
    public boolean active(String code) {
        User user = userDao.findByCode(code);
        if(user!=null){
            userDao.updateStatus(user);
            return true;
        }
        return false;
    }

    @Override
    public User login(User user) {
        return userDao.findByUsernameAndPassword(user);
    }
}
