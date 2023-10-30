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
    if (cpu.equals("Pa")) {
      if (user.equals("Gu")) {
        return "You Lose";
      } else if (user.equals("Choki")) {
        return "You Win";
      } else {
        return "drow";
      }
    } else if (cpu.equals("Choki")) {
      if (user.equals("Pa")) {
        return "You Lose";
      } else if (user.equals("Gu")) {
        return "You Win";
      } else {
        return "drow";
      }
    } else if (cpu.equals("Gu")) {
      if (user.equals("Pa")) {
        return "You Win";
      } else if (user.equals("Choki")) {
        return "You Lose";
      } else {
        return "drow";
      }
    }
    return "";
  }

}
