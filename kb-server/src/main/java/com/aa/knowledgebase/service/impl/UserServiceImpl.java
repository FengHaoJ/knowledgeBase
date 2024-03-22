package com.aa.knowledgebase.service.impl;


import com.aa.knowledgebase.constant.MessageConstant;
import com.aa.knowledgebase.domain.dto.UserDTO;
import com.aa.knowledgebase.domain.po.User;

import com.aa.knowledgebase.exception.AccountNotFoundException;
import com.aa.knowledgebase.mapper.UserMapper;
import com.aa.knowledgebase.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;


    @Override
    public User login(UserDTO userDTO) {
        String username = userDTO.getUsername();
        String password = userDTO.getPassword();

        // 1.根据用户名查询数据库中的数组（用户名唯一）
        User user = userMapper.getByUsername(username);

        if(user == null){
            //账号不存在
            throw new AccountNotFoundException(MessageConstant.ACCOUNT_NOT_FOUND);
        }

        //密码比对
        //对前端传过来的明文密码进行md5加密处理
//        password = DigestUtils.md5DigestAsHex(password.getBytes());
//        if(!password.equals(user.getPassword())){
//            //密码错误
//
//        }


        return user;
    }
}
