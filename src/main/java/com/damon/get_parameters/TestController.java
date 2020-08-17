package com.damon.get_parameters;

import com.damon.get_parameters.domain.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1")
public class TestController {


    /**
     * 测试Restful风格的请求如何获得对应的参数,可以是各种请求Get,Post,Put,Delete代表不同的动作
     * @param id
     * @return
     */
    @GetMapping("/test1/{id}")
    public String test1(@PathVariable Integer id){
        System.out.println(id);
        return "ok";
    }

    /**
     * 测试ResquestBody注解自动将body中的json数据转换为对应的实体类
     * @param id
     * @param user
     * @return
     */
    @RequestMapping("/test2/{id}")
    public String test2(@PathVariable Integer id, @RequestBody User user){
        System.out.println(id);
        System.out.println(user);
        return "ok";
    }

    /**
     * 测试如何取得普通url中带的参数
     * 方式一 ： 直接放到参数列表中，参数名要一致
     * @return
     */
    @RequestMapping("/test3/{id}")
    public String test3(String username,String password){
        System.out.println(username);
        System.out.println(password);
        return "ok";
    }    /**
     * 测试如何取得普通url中带的参数
     * 方法二 ： 使用RequestParam注解
     * @RequestParam 有三个参数
     * 1. value：请求参数名（必须配置）单一参数时，可简化直接填字符串
     * 2. required：是否必需，默认为 true，即 请求中必须包含该参数，如果没有包含，将会抛出异常（可选配置）
     * 3. defaultValue：默认值，如果设置了该值，required 将自动设为 false，无论你是否配置了required，配置了什么值，都是 false；如果没有传该参数，就使用默认值（可选配置）
     * @return
     */
    @RequestMapping("/test4/{id}")
    public String test4(@RequestParam("username") String usr,@RequestParam(value = "password",required = false) String pwd){
        System.out.println(usr);
        System.out.println(pwd);
        return "ok";
    }
}
