package com.fengwenyi.vueadminproapi.result;

import lombok.Getter;

/**
 * @author Erwin Feng
 * @since 2019-08-06 09:26
 */
@Getter
public class CodeMsg {

    public final static CodeMsg SUCCESS = new CodeMsg(0, "Success")

    , ERROR_COMMON_CUSTOM_EXCEPTION         = new CodeMsg(1000000, "未定义异常：%s")


    /*======================服务错误：101xxx===========================================*/
    , ERROR_SERVICE_404                     = new CodeMsg(1001001, "404")
    , ERROR_SERVICE_EXCEPTION               = new CodeMsg(1001002, "内部服务错误")


    /*======================通用错误：102xxx===========================================*/
    , ERROR_COMMON_REQUEST_EXCEPTION        = new CodeMsg(1002001, "请求异常：%s")
    , ERROR_COMMON_PARAM_EXCEPTION          = new CodeMsg(1002002, "参数异常：%s")
    , ERROR_COMMON_BIND_EXCEPTION           = new CodeMsg(1002003, "约束异常：%s")
    , ERROR_COMMON_ENCRYPT_EXCEPTION        = new CodeMsg(1002004, "加密异常：%s")
    , ERROR_COMMON_DATA_EXCEPTION           = new CodeMsg(1002005, "数据异常：%s")
    , ERROR_COMMON_ILLEGAL_REQUEST          = new CodeMsg(1002006, "非法请求：%s")
    , ERROR_COMMON_VALIDATION_EXCEPTION     = new CodeMsg(1002007, "校验异常：%s")

    /*======================验证相关错误：103xxx===========================================*/

    , ERROR_AUTH_ACCOUNT_NOT_NULL           = new CodeMsg(1003001, "账号不能为空")
    , ERROR_AUTH_PASSWORD_NOT_NULL          = new CodeMsg(1003002, "密码不能为空")
    , ERROR_AUTH_ACCOUNT_NOT_EXIST          = new CodeMsg(1003003, "账号不存在")
    , ERROR_AUTH_PASSWORD_INCORRECT         = new CodeMsg(1003004, "密码不正确")

    /*======================参数错误：103xxx===========================================*/
    , ERROR_PARAM_ILLEGAL                   = new CodeMsg(1004001, "参数非法异常：%s")
    , ERROR_PARAM_JSON_INCORRECT            = new CodeMsg(1004002, "参数JSON格式不正确")

    ;

    private int code;

    private String msg;

    public CodeMsg() {

    }

    public CodeMsg(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     * 验证返回码是否重复
     * @return
     */
    /*public static boolean verifyCodeRepeat() {
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
    }*/

    /**
     * 返回码填充
     * @param args 填充内容
     * @return CodeMsgEnum
     */
    public CodeMsg fillArgs(Object ... args) {

        String msg = String.format(this.msg, args);

        return new CodeMsg(this.getCode(), msg);
    }
}
