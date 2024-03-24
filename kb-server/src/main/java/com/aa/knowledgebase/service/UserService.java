package com.aa.knowledgebase.service;

import com.aa.knowledgebase.domain.dto.UserLoginDTO;
import com.aa.knowledgebase.domain.dto.UserRegisterDTO;
import com.aa.knowledgebase.domain.po.User;


public interface UserService {


    User login(UserLoginDTO userLoginDTO);

    User userRegister(UserRegisterDTO userRegisterDTO);
}
