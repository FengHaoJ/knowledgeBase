package com.aa.knowledgebase.service;

import com.aa.knowledgebase.domain.dto.UserDTO;
import com.aa.knowledgebase.domain.po.User;
import org.springframework.stereotype.Service;


public interface UserService {


    User login(UserDTO userDTO);
}
