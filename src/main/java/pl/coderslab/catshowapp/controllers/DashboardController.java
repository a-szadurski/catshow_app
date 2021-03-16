package pl.coderslab.catshowapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user/dashboard")
public class DashboardController {

    @GetMapping("/main")
    public String dashboardMainDisplay(){
        return "user/dashboard-main";
    }

}
