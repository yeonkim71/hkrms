package com.hkilbo.hkrms.giro;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/giro/main")
    public String home() {
        return "giro/index";
    }

}