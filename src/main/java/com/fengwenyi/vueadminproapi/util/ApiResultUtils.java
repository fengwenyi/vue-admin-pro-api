package com.fengwenyi.vueadminproapi.util;

import com.fengwenyi.api_result.helper.ApiResultHelper;
import com.fengwenyi.api_result.model.ApiResultModel;
import com.fengwenyi.vueadminproapi.result.CodeMsg;

/**
 * @author Erwin Feng
 * @since 2019-08-06 09:24
 */
public class ApiResultUtils {

    // 成功，数据
    public static <T> ApiResultModel success(T data) {
        return ApiResultHelper.success(CodeMsg.SUCCESS.getCode(), CodeMsg.SUCCESS.getMsg(), data);
    }

    // 成功
    public static ApiResultModel success() {
        return ApiResultHelper.success(CodeMsg.SUCCESS.getCode(), CodeMsg.SUCCESS.getMsg());
    }

    // 错误
    public static ApiResultModel error(CodeMsg codeMsg) {
        return ApiResultHelper.error(codeMsg.getCode(), codeMsg.getMsg());
    }

}
