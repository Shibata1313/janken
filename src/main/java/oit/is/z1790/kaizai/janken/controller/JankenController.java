package oit.is.z1790.kaizai.janken.controller;

import java.security.Principal;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import oit.is.z1790.kaizai.janken.model.Janken;
import oit.is.z1790.kaizai.janken.model.UserMapper;
import oit.is.z1790.kaizai.janken.model.Entry;
import oit.is.z1790.kaizai.janken.model.User;
import oit.is.z1790.kaizai.janken.model.UserMapper;
import oit.is.z1790.kaizai.janken.model.Match;
import oit.is.z1790.kaizai.janken.model.MatchMapper;

@Controller
public class JankenController {

  @Autowired
  private Entry entry;

  private User user;

  @Autowired
  private UserMapper userMapper;

  @Autowired
  private MatchMapper matchMapper;

  @PostMapping("/janken")
  public String janken(@RequestParam String userName, ModelMap model) {
    model.addAttribute("userName", userName);
    return "janken.html";
  }

  @GetMapping("/janken")
  @Transactional
  public String janken(ModelMap model, Principal prin) {
    String playerName = prin.getName(); // ログインユーザ情報
    this.entry.addUser(playerName);
    model.addAttribute("entry", this.entry);
    model.addAttribute("login_user", playerName);
    ArrayList<User> users1 = userMapper.selectAllUser();
    ArrayList<Match> matches1 = matchMapper.selectAllMatch();
    model.addAttribute("users1", users1);
    model.addAttribute("matches1", matches1);

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

  @GetMapping("/match")
  public String match(@RequestParam Integer id, ModelMap model, Principal prin) {
    String playerName = prin.getName();
    user = userMapper.selectById(id);
    model.addAttribute("user", user);
    model.addAttribute("player", playerName);
    return "match.html";
  }

  @GetMapping("/fight")
  public String fight(@RequestParam Integer id, @RequestParam String hand, ModelMap model, Principal prin) {
    String playerName = prin.getName();
    Janken janken = new Janken();
    Match match = new Match();
    String cpuHand = "Gu";
    String winer;
    match.setUser1(userMapper.selectByUserName(playerName).getId());
    match.setUser2(id);
    match.setUser1Hand(hand);
    match.setUser2Hand(cpuHand);
    winer = janken.pon(cpuHand, hand);
    model.addAttribute("hand", hand);
    model.addAttribute("cpuHand", cpuHand);
    model.addAttribute("winer", winer);
    model.addAttribute("user", user);
    model.addAttribute("player", playerName);
    matchMapper.insertUserInfo(match);
    return "match.html";
  }

}
