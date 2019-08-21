package com.fengwenyi.vueadminproapi.controller;

import com.fengwenyi.api_result.model.ApiResultModel;
import com.fengwenyi.vueadminproapi.entity.Login;
import com.fengwenyi.vueadminproapi.result.CodeMsg;
import com.fengwenyi.vueadminproapi.util.ApiResultUtils;
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
    public ApiResultModel login(@RequestBody Login login) {
        String account = login.getAccount();
        String password = login.getPassword();
        if (StringUtils.isEmpty(account)) {
            return ApiResultUtils.error(CodeMsg.ERROR_AUTH_ACCOUNT_NOT_NULL);
        }
        if (StringUtils.isEmpty(password)) {
            return ApiResultUtils.error(CodeMsg.ERROR_AUTH_PASSWORD_NOT_NULL);
        }
        if (!account.equals("admin")) {
            return ApiResultUtils.error(CodeMsg.ERROR_AUTH_ACCOUNT_NOT_EXIST);
        }
        if (!password.equals("admin@1234")) {
            return ApiResultUtils.error(CodeMsg.ERROR_AUTH_PASSWORD_INCORRECT);
        }
        String uid = IdUtils.getIdByUUID();
        String token = IdUtils.getIdByUUID();
        // 可指定有效期
        // 可自定义策略保存uid、token
        // write code
        Map<String, String> map = new HashMap<>();
        map.put("token", uid + "_" + token);
        return ApiResultUtils.success(map);
    }

    /**
     * 登出示例
     * @param token
     * @return
     */
    @GetMapping("/logout")
    public ApiResultModel logout(@RequestHeader String token) {
        // 清空token
        // write code

        // return
        return ApiResultUtils.success();
    }

}
