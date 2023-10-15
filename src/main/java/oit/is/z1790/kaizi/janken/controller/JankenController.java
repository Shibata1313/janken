package oit.is.z1790.kaizi.janken.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import oit.is.z1790.kaizi.janken.model.Janken;

@Controller
public class JankenController {
  @PostMapping("/janken")
  public String janken(@RequestParam String userName, ModelMap model) {
    model.addAttribute("userName", userName);
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
