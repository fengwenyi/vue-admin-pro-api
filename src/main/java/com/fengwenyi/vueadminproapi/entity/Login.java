package com.fengwenyi.vueadminproapi.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author Erwin Feng
 * @since 2019-06-08 10:26
 */
@Data
@Accessors(chain = true)
public class Login implements Serializable {

    private static final long serialVersionUID = 1954345518867428563L;

    /** 账号 */
    private String account;

    /** 密码 */
    private String password;
}
