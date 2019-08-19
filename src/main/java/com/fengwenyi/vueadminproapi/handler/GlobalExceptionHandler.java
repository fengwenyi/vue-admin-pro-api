package com.fengwenyi.vueadminproapi.handler;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import com.fengwenyi.api_result.model.ApiResultModel;
import com.fengwenyi.vueadminproapi.result.CodeMsg;
import com.fengwenyi.vueadminproapi.util.ResultUtils;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 全局异常处理
 * @author Erwin Feng
 * @since 2019-08-19 16:40
 */
@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {

    /*=============请求错误 start==============================================*/

    /**
     * HTTP 请求方式不支持异常
     * HttpRequestMethodNotSupportedException
     * @return {@link com.fengwenyi.api_result.model.ApiResultModel}
     */
    @ExceptionHandler(value = HttpRequestMethodNotSupportedException.class)
    public ApiResultModel httpRequestMethodNotSupportException(HttpRequestMethodNotSupportedException e, HttpServletRequest request) {
//        return ResultUtils.error(CodeMsg.ERROR_COMMON_REQUEST_EXCEPTION.fillArgs("请求方法不支持"));
        return ResultUtils.error(CodeMsg.ERROR_COMMON_REQUEST_EXCEPTION);
    }

    /**
     * 请求方式不支持
     * @return {@link com.fengwenyi.api_result.model.ApiResultModel}}
     */
    @ExceptionHandler(value = HttpMediaTypeNotSupportedException.class)
    public ApiResultModel httpMediaTypeNotSupportException(HttpMediaTypeNotSupportedException e, HttpServletRequest request) {
//        return ResultUtils.error(CodeMsg.ERROR_COMMON_REQUEST_EXCEPTION.fillArgs("请求媒体类型不支持"));
        return ResultUtils.error(CodeMsg.ERROR_COMMON_REQUEST_EXCEPTION);
    }

    /**
     * Http 数据不可读
     * @param e
     * @return
     */
    /*@ExceptionHandler(value = HttpMessageNotReadableException.class)
    public ApiResult<String> httpMessageNotReadableException(HttpMessageNotReadableException e, HttpServletRequest request) {
        ApiResult<String> apiResult = ApiResult.error(CodeMsg.ERROR_COMMON_REQUEST_EXCEPTION.fillArgs("请求数据不可读"));
        String METHOD_NAME = "httpMessageNotReadableException";
        String CLASS_NAME = this.getClass().getName();
        apiLogService.sendKafka("", CLASS_NAME, METHOD_NAME, LogLevel.ERROR, e.getCause().toString(), "", apiResult, request);
        return apiResult;
    }*/

    /*=============请求错误 end==============================================*/



    /*=============参数错误 start==============================================*/


    /**
     * JSON 格式化异常
     * @return {@link com.fengwenyi.api_result.model.ApiResultModel}}
     */
    @ExceptionHandler(value = MismatchedInputException.class)
    public ApiResultModel mismatchedInputException(MismatchedInputException e, HttpServletRequest request) {
        return ResultUtils.error(CodeMsg.ERROR_PARAM_JSON_INCORRECT);
    }


    /**
     * JSON 格式化异常
     * @return {@link com.fengwenyi.api_result.model.ApiResultModel}}
     */
    @ExceptionHandler(value = JsonParseException.class)
    public ApiResultModel jsonParseException(JsonParseException e, HttpServletRequest request) {
        return ResultUtils.error(CodeMsg.ERROR_PARAM_JSON_INCORRECT);
    }

    /**
     * JSON 映射异常
     * @return {@link com.fengwenyi.api_result.model.ApiResultModel}}
     */
    @ExceptionHandler(value = JsonMappingException.class)
    public ApiResultModel jsonMappingException(JsonMappingException e, HttpServletRequest request) {
        return ResultUtils.error(CodeMsg.ERROR_PARAM_JSON_INCORRECT);
    }

    /**
     * Http 数据不可读
     * @param e
     * @return
     */
    @ExceptionHandler(value = HttpMessageNotReadableException.class)
    public ApiResultModel httpMessageNotReadableException(HttpMessageNotReadableException e, HttpServletRequest request) {
//        return ResultUtils.error(CodeMsg.ERROR_COMMON_REQUEST_EXCEPTION.fillArgs(e.getMessage()));
        return ResultUtils.error(CodeMsg.ERROR_COMMON_REQUEST_EXCEPTION);
//        ApiResult apiResult = ApiResult.error().setCode(102001).setMsg("请求异常：" + e.getMessage());
    }

    /**
     * 非法参数异常
     * @return {@link com.fengwenyi.api_result.model.ApiResultModel}}
     */
    @ExceptionHandler(value = IllegalArgumentException.class)
    public ApiResultModel illegalArgumentException(IllegalArgumentException e, HttpServletRequest request) {
//        return ResultUtils.error(CodeMsg.ERROR_PARAM_ILLEGAL.fillArgs(e.getMessage()));
        return ResultUtils.error(CodeMsg.ERROR_PARAM_ILLEGAL);

    }

    /**
     * 参数绑定异常
     * @return {@link com.fengwenyi.api_result.model.ApiResultModel}}
     */
    /*@ExceptionHandler(value = BindException.class)
    public ApiResult<String> bindException(BindException e, HttpServletRequest request) {
        List<ObjectError> allErrors = e.getAllErrors();
        StringBuilder stringBuilder = new StringBuilder();
        for (ObjectError objectError : allErrors) {
            String msg = objectError.getDefaultMessage();
            stringBuilder.append(msg);
            stringBuilder.append(", ");
        }
        PrintUtils.info("=======================> bindException");
        return ApiResult.error(CodeMsg.ERROR_COMMON_BIND_EXCEPTION.fillArgs(stringBuilder.substring(0, stringBuilder.length() - 2)));
    }*/


    /**
     * 方法参数校验异常
     * @return {@link com.fengwenyi.api_result.model.ApiResultModel}}
     */
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ApiResultModel methodArgumentNotValidException(MethodArgumentNotValidException e, HttpServletRequest request) {
        BindingResult bindingResult = e.getBindingResult();
        List<ObjectError> allErrors = bindingResult.getAllErrors();
        StringBuilder stringBuilder = new StringBuilder();
        for (ObjectError objectError : allErrors) {
            String msg = objectError.getDefaultMessage();
            stringBuilder.append(msg);
            stringBuilder.append(", ");
//             PrintUtils.info(msg);
        }
//        Object target = bindingResult.getTarget();
//        BaseParamVO baseParamVO = (BaseParamVO) target;
        return ResultUtils.error(CodeMsg.ERROR_COMMON_VALIDATION_EXCEPTION.fillArgs(stringBuilder.substring(0, stringBuilder.length() - 2)));
//        ApiResult apiResult = ApiResult.error().setCode(102007).setMsg("校验异常：" + stringBuilder.substring(0, stringBuilder.length() - 2));

    }

    /*=============参数错误 end==============================================*/



}
