package com.fengwenyi.vueadminproapi.util;

import com.fengwenyi.api_result.helper.ResultHelper;
import com.fengwenyi.api_result.model.ApiResultModel;
import com.fengwenyi.vueadminproapi.result.CodeMsg;

/**
 * @author Erwin Feng
 * @since 2019-08-06 09:24
 */
public class ResultUtils {

    // 成功，数据
    public static <T> ApiResultModel success(T data) {
        return ResultHelper.success(CodeMsg.SUCCESS.getCode(), CodeMsg.SUCCESS.getMsg(), data);
    }

    // 成功
    public static ApiResultModel success() {
        return ResultHelper.success(CodeMsg.SUCCESS.getCode(), CodeMsg.SUCCESS.getMsg());
    }

    // 错误
    public static ApiResultModel error(CodeMsg codeMsg) {
        return ResultHelper.error(codeMsg.getCode(), codeMsg.getMsg());
    }

}
