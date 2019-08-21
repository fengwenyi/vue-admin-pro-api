package com.fengwenyi.vueadminproapi.controller;

import com.fengwenyi.api_result.helper.ApiResultHelper;
import com.fengwenyi.api_result.model.ApiResultModel;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Api Result Example
 * @author Erwin Feng
 * @since 2019-08-21 12:17
 */
@RestController
@RequestMapping("/example")
public class Example {

    @RequestMapping("/data")
    public ApiResultModel data() {
        List<Map<String, Object>> list = new ArrayList<>();
        Map<String, Object> map1 = new HashMap<>();
        map1.put("name", "Zhangsan");
        map1.put("age", "18");
        list.add(map1);
        Map<String, Object> map2 = new HashMap<>();
        map2.put("name", "Lisi");
        map2.put("age", "20");
        list.add(map2);
        return ApiResultHelper.success(0, "Success", list);
    }

}
