package com.mir.app.simplecloud;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FrontController {

    @GetMapping("/test")
    public String index(ModelMap modelMap) {
        modelMap.addAttribute("sample","test");
        return "index";
    }

}
