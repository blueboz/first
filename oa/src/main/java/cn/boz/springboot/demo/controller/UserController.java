package cn.boz.springboot.demo.controller;


import cn.boz.springboot.demo.entity.User;
import cn.boz.springboot.demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class UserController {

    @RequestMapping("/getUsers")
    public List<User> queryAllUsers(){
        return null;
    }

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @RequestMapping("/whoami")
    public User queryCurrentUser(){
        User user = new User();
        user.setUsername("boz");
        user.setPhone("13690077489");
        user.setBirth(new Date());
        user.setAddr("广东省潮州市");
        user.setEmail("1173621@qq.com");
        user.setGender("Male");
        return user;
    }

    @RequestMapping("/getUsers2")
    public List<Map<String, Object>> getDbType(){
        String sql = "select * from user";
        List<Map<String, Object>> list =  jdbcTemplate.queryForList(sql);
        for (Map<String, Object> map : list) {
            Set<Map.Entry<String, Object>> entries = map.entrySet( );
            if(entries != null) {
                Iterator<Map.Entry<String, Object>> iterator = entries.iterator( );
                while(iterator.hasNext( )) {
                    Map.Entry<String, Object> entry =(Map.Entry<String, Object>) iterator.next( );
                    Object key = entry.getKey( );
                    Object value = entry.getValue();
                    System.out.println(key+":"+value);
                }
            }
        }
        return list;
    }

    @RequestMapping("/getTables")
    public List<Map<String,Object>> queryTables(){
        List<Map<String, Object>> list =jdbcTemplate.queryForList("select * from tabs");
        return list;
    }

    @RequestMapping("/tabsInfo")
    public List<Map<String, Object>> queryMyTabsDetails(){
        return jdbcTemplate.queryForList("select * from information_schema.`TABLES` where table_schema='test'");
    }

    private UserMapper userMapper=null;

    @RequestMapping("/getUserMb")
    public List<Map<String,Object>> queryUserInMB(){
        System.out.println(userMapper);
        return null;
    }


}
