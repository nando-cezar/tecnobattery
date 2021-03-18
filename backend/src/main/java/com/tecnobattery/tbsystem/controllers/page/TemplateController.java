package com.tecnobattery.tbsystem.controllers.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class TemplateController {

  @GetMapping("main")
  public String getMain() {
    return "main";
  }

  @GetMapping("login")
  public String getLogin() {
    return "login";
  }
}
