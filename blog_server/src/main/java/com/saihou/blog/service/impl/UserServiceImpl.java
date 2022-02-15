package com.saihou.blog.service.impl;

import com.saihou.blog.dao.UserDao;
import com.saihou.blog.entity.User;
import com.saihou.blog.service.UserService;
import com.saihou.blog.util.PageResult;
import com.saihou.blog.util.ShiroUtil;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author saihou
 * @version 1.0
 * @date 2022/02/14 15:46
 */
@Service
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public PageResult<User> findAll(Integer start, Integer size, Integer displayPages) {
        Pageable pageable = PageRequest.of(start, size);
        Page<User> page = userDao.findAll(pageable);

        return new PageResult<>(page, displayPages);
    }

    @Override
    public User findById(Integer id) {
        return userDao.getById(id);
    }

    @Override
    public User findByName(String name) {
        return userDao.findByName(name);
    }

    @Override
    public User insert(User user) {
        return userDao.save(user);
    }

    @Override
    public User update(User user) {
        String salt = new SecureRandomNumberGenerator().nextBytes().toString();
        String encodePassword = ShiroUtil.encrypt(user.getPassword(), salt);

        user.setSalt(salt);
        user.setPassword(encodePassword);
        user.setModifiedDate(new Date());

        return userDao.save(user);
    }

    @Override
    public void deleteById(Integer id) {
        userDao.deleteById(id);
    }

    @Override
    public boolean passwordCheck(User userInDb, String oldPassword) {
        String passwordInDb = userInDb.getPassword();
        String saltInDb = userInDb.getSalt();

        String encodePassword = ShiroUtil.encrypt(oldPassword, saltInDb);

        return encodePassword.equals(passwordInDb);
    }

}
