package com.robert.test.shirodemo.dto;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.robert.test.shirodemo.constant.ShiroConstant;
import com.robert.test.shirodemo.util.SaltUtil;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public void register(User user) {
        // 生成随机盐
        String salt = SaltUtil.getSalt(ShiroConstant.SALT_LENGTH);
        // 保存随机盐
        user.setSalt(salt);
        // 生成密码
        Md5Hash password = new Md5Hash(user.getPassword(), salt, ShiroConstant.HASH_ITERATORS);
        // 保存密码
        user.setPassword(password.toHex());
        userMapper.insert(user);
    }
    @Override
    public User findUserByUserName(String userName) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username",userName);

        return userMapper.selectOne(queryWrapper);
    }
}

