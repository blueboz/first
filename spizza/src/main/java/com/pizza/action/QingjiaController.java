package com.pizza.action;

import com.pizza.domain.Qingjiadan;
import org.springframework.stereotype.Controller;

/**
 * qingjiaController#init
 */
@Controller
public class QingjiaController {

    public Qingjiadan processQingjiadan(Qingjiadan qingjiadan) {
        System.out.println(qingjiadan.getDate());
        return qingjiadan;
    }
}
