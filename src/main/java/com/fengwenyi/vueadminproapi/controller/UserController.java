package com.fengwenyi.vueadminproapi.controller;

import com.fengwenyi.api_result.model.ApiResultModel;
import com.fengwenyi.vueadminproapi.util.ApiResultUtils;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * @author Erwin Feng
 * @since 2019-06-10 09:49
 */
@RestController
@RequestMapping(value = "/user",
        consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
        produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class UserController {

    @GetMapping("/{uid}")
    public ApiResultModel logout(@PathVariable String uid, @RequestHeader String token) {
        return ApiResultUtils.success();
    }

}
