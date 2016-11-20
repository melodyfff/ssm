package com.xinchen.ssm.demo.controller;

/**
 * Created by wow on 2016/11/20.
 */

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginLogoutController {
    protected static Logger logger = Logger.getLogger("controller");
/*
	@Autowired
	private CustomUserDetailsService customUserDetailsService; */
    /**
     * 指向登录界面
     *
     * @param error
     * @param model
     * @return
     */
    @RequestMapping(value = "/security/login")
    public String getLoginPage(@RequestParam(value = "error", required = false) boolean error, ModelMap model) {

        logger.debug("Received request to show login page");

        if (error == true) {
            // Assign an error message
            model.put("error", "用户名或密码错误!");
        } else {
            model.put("error", "");
        }
        return "/security/loginpage";

    }

    /**
     * 指定无权限访问界面
     *
     * @return
     */
    @RequestMapping(value = "/security/denied")
    public String getDeniedPage() {
        logger.debug("Received request to show denied page");
        return "/security/deniedpage";

    }

}
