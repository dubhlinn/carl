package cn.monolog.dubhlinn.carl.test;

import cn.monolog.dubhlinn.carl.util.HttpRequestUtil;
import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * http请求工具测试类
 * @author dubhlinn
 * @date 2020-01-07
 */
public class HttpRequestUtilTest {

    /**
     * 测试get请求
     */
    @Test
    public void testDoGet() {
        String head = "http://";
        String url = "127.0.0.1:8090/index/unauthenticated";
        String responseResult = HttpRequestUtil.doGet(head + url);
        System.out.println(responseResult);
    }

    @Test
    public void testDoPost() {
        String head = "http://";
        String url = "127.0.0.1:8090/index/login";
        Map<String, String> param = new HashMap<>();
        param.put("userName", "zhuanjia");
        param.put("password", "123456");
        String jsonParam = JSON.toJSONString(param);
        String responseResult = HttpRequestUtil.doPost(head + url, jsonParam);
        System.out.println(responseResult);
    }
}
