package com.fengwenyi.vueadminproapi.controller;

import com.fengwenyi.vueadminproapi.entity.Login;
import net.iutil.ApiResult;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * 认证
 * @author Erwin Feng
 * @since 2019-06-08 10:21
 */
@RestController
@RequestMapping(value = "/auth",
        consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
        produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class AuthController {

    @PostMapping("/login")
    public ApiResult login(@RequestBody Login login) {
        String account = login.getAccount();
        String password = login.getPassword();
        if (StringUtils.isEmpty(account))
            return ApiResult.error().setCode(10001).setMsg("账号不能为空");
        if (StringUtils.isEmpty(password))
            return ApiResult.error().setCode(10002).setMsg("密码不能为空");
        if (!account.equals("admin"))
            return ApiResult.error().setCode(10003).setMsg("账号不存在");
        if (!password.equals("admin@1234"))
            return ApiResult.error().setCode(10004).setMsg("密码不正确");
        Map<String, String> map = new HashMap<>();
        map.put("token", UUID.randomUUID().toString());
        map.put("uid", UUID.randomUUID().toString());
        return ApiResult.success(map);
    }

    @GetMapping("/logout")
    public ApiResult logout(@RequestHeader String token) {
        return ApiResult.success();
    }

}
