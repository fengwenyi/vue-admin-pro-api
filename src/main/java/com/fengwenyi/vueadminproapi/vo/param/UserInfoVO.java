package com.fengwenyi.vueadminproapi.vo.param;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @author Erwin Feng
 * @since 2019-08-19 17:12
 */
@Getter
@Setter
public class UserInfoVO {

    @NotBlank(message = "用户名(username)不能为空")
    private String username;

    @NotNull(message = "年龄(age)不能为空")
    @Min(value = 0, message = "年龄(age)不能小于0")
    private Integer age;

}
