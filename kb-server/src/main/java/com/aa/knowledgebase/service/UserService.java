package com.aa.knowledgebase.service;

import com.aa.knowledgebase.domain.dto.UserDTO;
import com.aa.knowledgebase.domain.po.User;


public interface UserService {


    User login(UserDTO userDTO);
}
