package com.bw.controller;

import com.bw.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.POST;

/**
 * Created by lenovo on 2017/7/21.
 */
@RestController
public class DcController {
    @Autowired
    DiscoveryClient discoveryClient;

    /**
     * 客户端,可以获取服务端的信息
     * 注意:
     *
     *
     * @return
     */
    @GetMapping("/dc")
    public String dc(){
        String services = "Services: " + discoveryClient.getServices();
         System.out.println(services);
         return services;
    }

    /**
     * get请求
     * @param id
     * @param name
     * @return
     */
    @GetMapping("get")
    public User get(@RequestParam("id") Integer id, @RequestParam("name") String name){
        User user = new User(id,name);
        return user;
    }

    /**
     * post请求
     */
    @PostMapping("post")
    public User post(@RequestBody User user){
        System.out.println(user);
        return user;
    }
}
