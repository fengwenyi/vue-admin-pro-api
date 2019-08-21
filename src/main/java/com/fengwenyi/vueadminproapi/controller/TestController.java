package com.fengwenyi.vueadminproapi.controller;

import com.fengwenyi.api_result.model.ApiResultModel;
import com.fengwenyi.vueadminproapi.util.ApiResultUtils;
import com.fengwenyi.vueadminproapi.vo.param.UserInfoVO;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试
 * @author Erwin Feng
 * @since 2019-08-19 17:09
 */
@RestController
@RequestMapping(value = "/test",
        consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
        produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class TestController {

    /**
     * 参数测试
     * @param vo
     * @return
     */
    @PostMapping("/userInfo")
    public ApiResultModel userInfo(@RequestBody @Validated UserInfoVO vo) {
        return ApiResultUtils.success(vo);
    }

}
