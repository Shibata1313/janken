package oit.is.z1790.kaizai.janken.model;

public class Janken {
  String userName;

  public Janken() {
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String pon(String cpu, String user) {
    if (cpu.equals("pa")) {
      if (user.equals("gu")) {
        return "You Lose";
      } else if (user.equals("choki")) {
        return "You Win";
      } else {
        return "drow";
      }
    } else if (cpu.equals("choki")) {
      if (user.equals("pa")) {
        return "You Lose";
      } else if (user.equals("gu")) {
        return "You Win";
      } else {
        return "drow";
      }
    } else if (cpu.equals("gu")) {
      if (user.equals("pa")) {
        return "You Win";
      } else if (user.equals("choki")) {
        return "You Lose";
      } else {
        return "drow";
      }
    }
    return "";
  }

}
