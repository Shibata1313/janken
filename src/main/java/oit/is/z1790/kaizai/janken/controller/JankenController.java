package oit.is.z1790.kaizai.janken.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import oit.is.z1790.kaizai.janken.model.Janken;
import oit.is.z1790.kaizai.janken.model.Entry;

@Controller
public class JankenController {

  @Autowired
  private Entry entry;

  @PostMapping("/janken")
  public String janken(@RequestParam String userName, ModelMap model) {
    model.addAttribute("userName", userName);
    return "janken.html";
  }

  @GetMapping("/janken")
  public String janken(ModelMap model, Principal prin) {
    String loginUser = prin.getName(); // ログインユーザ情報
    this.entry.addUser(loginUser);
    model.addAttribute("entry", this.entry);
    model.addAttribute("login_user", loginUser);
    return "janken.html";
  }

  @GetMapping("/jankengame")
  public String jankengame(@RequestParam String userHand, ModelMap model) {
    Janken janken = new Janken();
    String cpuHand = "gu";
    String winer;
    winer = janken.pon(cpuHand, userHand);
    model.addAttribute("userHand", userHand);
    model.addAttribute("cpuHand", cpuHand);
    model.addAttribute("winer", winer);
    return "janken.html";
  }

}
