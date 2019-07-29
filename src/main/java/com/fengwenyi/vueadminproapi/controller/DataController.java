package com.fengwenyi.vueadminproapi.controller;

import lombok.extern.slf4j.Slf4j;
import net.iutil.ApiResult;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * @author Erwin Feng
 * @since 2019-07-29 09:31
 */
@Slf4j
@RestController
@RequestMapping(value = "/data",
        consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
        produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class DataController {

    @PostMapping("/test")
    public ApiResult test(@RequestHeader String token, @RequestBody Object data) {
        log.info("token: {}", token);
        log.info("data: {}", data);
        return ApiResult.success("这是服务响应的数据-test");
    }

}
