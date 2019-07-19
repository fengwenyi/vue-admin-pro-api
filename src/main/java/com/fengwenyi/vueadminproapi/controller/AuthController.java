package com.fengwenyi.vueadminproapi.controller;

import com.fengwenyi.vueadminproapi.entity.Login;
import net.iutil.ApiResult;
import net.iutil.javalib.util.IdUtils;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * 认证，登录 / 登出
 * @author Erwin Feng
 * @since 2019-06-08 10:21
 */
@RestController
@RequestMapping(value = "/auth",
        consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
        produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class AuthController {

    /**
     * 登录示例
     * @param login
     * @return
     */
    @PostMapping("/login")
    public ApiResult login(@RequestBody Login login) {
        String account = login.getAccount();
        String password = login.getPassword();
        if (StringUtils.isEmpty(account))
            return ApiResult.error().setMsg("账号不能为空");
        if (StringUtils.isEmpty(password))
            return ApiResult.error().setMsg("密码不能为空");
        if (!account.equals("admin"))
            return ApiResult.error().setMsg("账号不存在");
        if (!password.equals("admin@1234"))
            return ApiResult.error().setMsg("密码不正确");
        String uid = IdUtils.getIdByUUID();
        String token = IdUtils.getIdByUUID();
        // 可指定有效期
        // 可自定义策略保存uid、token
        // write code
        Map<String, String> map = new HashMap<>();
        map.put("token", uid + "_" + token);
        return ApiResult.success(map);
    }

    /**
     * 登出示例
     * @param token
     * @return
     */
    @GetMapping("/logout")
    public ApiResult logout(@RequestHeader String token) {
        // 清空token
        // write code

        // return
        return ApiResult.success();
    }

}
