package com.pizza.action;

import com.pizza.domain.Qingjiadan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.PrintWriter;
import java.util.*;

@RestController
public class XmlJsonController {

    @RequestMapping("/xmlOrJson")
    public Map<String,Object> xmlOrJson(){
        Map<String, Object> map = new HashMap<>();
        Qingjiadan qin = new Qingjiadan();
        qin.setUser("blueboz");
        qin.setDate(new Date());
        qin.setReason("Without any");
        List<Qingjiadan> list = new ArrayList<>();
        map.put("list",list);
        map.put("user","jjjj");
        return map;
    }

    @RequestMapping("/qingjiadan")
    public Qingjiadan qingjiadan(){
        Qingjiadan qin = new Qingjiadan();
        qin.setUser("blueboz");
        qin.setDate(new Date());
        qin.setReason("我没有申请原因");
        return qin;

    }

    @RequestMapping(value = "/TestString")
    public String tesetString(){
        return "你好2";
    }


}
