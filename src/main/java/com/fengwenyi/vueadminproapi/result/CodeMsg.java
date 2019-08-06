package com.fengwenyi.vueadminproapi.result;

import lombok.Getter;

/**
 * @author Erwin Feng
 * @since 2019-08-06 09:26
 */
@Getter
public enum CodeMsg {
    SUCCESS(0, "Success"),

    // 验证相关
    ERROR_AUTH_ACCOUNT_NOT_NULL(1001001, "账号不能为空"),
    ERROR_AUTH_PASSWORD_NOT_NULL(1001002, "密码不能为空"),
    ERROR_AUTH_ACCOUNT_NOT_EXIST(1001003, "账号不存在"),
    ERROR_AUTH_PASSWORD_INCORRECT(1001004, "密码不正确"),

    ;

    private int code;

    private String msg;

    CodeMsg(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     * 验证返回码是否重复
     * @return
     */
    public static boolean verifyCodeRepeat() {
        CodeMsg[] values = CodeMsg.values();
        StringBuilder codeStr = new StringBuilder();
        for (CodeMsg codeMsg : values) {
            int code = codeMsg.code;
            if (codeStr.indexOf(code + "") == -1) {
                return true;
            }
            codeStr.append(code);
        }
        return false;
    }
}
