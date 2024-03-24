package com.aa.knowledgebase.controller.user;



import com.aa.knowledgebase.common.Result;
import com.aa.knowledgebase.domain.dto.UserLoginDTO;
import com.aa.knowledgebase.domain.dto.UserRegisterDTO;
import com.aa.knowledgebase.domain.po.User;
import com.aa.knowledgebase.domain.vo.UserVO;

import com.aa.knowledgebase.properties.JwtProperties;
import com.aa.knowledgebase.service.UserService;

import com.aa.knowledgebase.utils.JwtUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user/users")
@Api(tags = "用户接口")
@Slf4j
public class UserController {
    @Autowired
    private  UserService userService;
    @Autowired
    private JwtProperties jwtProperties;

    @PostMapping("/register")
    @ApiOperation("用户注册")
    public Result<User> register(@RequestBody UserRegisterDTO userRegisterDTO){
        log.info("新用户注册");
        User user = userService.userRegister(userRegisterDTO);
        return Result.success(user);
    }


    @PostMapping("/login")
    @ApiOperation("用户登录")
    public Result<UserVO> login(@RequestBody UserLoginDTO userLoginDTO){
        log.info("用户登录：{}", userLoginDTO);
        User user = userService.login(userLoginDTO);

        // 登录成功后，生成jwt令牌
        Map<String,Object> claims = new HashMap<>();
        claims.put("uid",user.getId());
        String token = JwtUtil.createJWT(
                jwtProperties.getUserSecretKey(),
                jwtProperties.getUserTtl(),
                claims);

        UserVO userVO = UserVO.builder()
                .id(user.getId())
                .userName(user.getUsername())
                .token(token)
                .build();

        return Result.success(userVO);
    }




}
