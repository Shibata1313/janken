package oit.is.z1790.kaizai.janken.model;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface MatchMapper {

  // @Select("SELECT id,name from user where id = #{id}")
  // User selectById(int id);

  /**
   * #{userName}などはinsertの引数にあるChamberクラスのフィールドを表しています 引数に直接String
   * userNameなどと書いてもいけるはず
   * 下記のOptionsを指定すると，insert実行時にAuto incrementされたIDの情報を取得できるようになる useGeneratedKeys
   * = true -> Keyは自動生成されることを表す keyColumn : keyになるテーブルのカラム名 keyProperty :
   * keyになるJavaクラスのフィールド名c3w3w3f
   *
   * @param chamber
   */

  // @Insert("INSERT INTO chamber (userName,chamberName) VALUES
  // (#{userName},#{chamberName});")
  // @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
  // void insertChamber(User chamber);

  // @Select("SELECT * from users where name = #{name}")
  // ArrayList<User> selectAllByUserName(String name);

  /**
   * DBのカラム名とjavaクラスのフィールド名が同じ場合はそのまま代入してくれる（大文字小文字の違いは無視される）
   * カラム名とフィールド名が異なる場合の対応も可能だが，いきなり複雑になるので，selectで指定するテーブル中のカラム名とクラスのフィールド名は同一になるよう設計することが望ましい
   *
   * @return
   */

  @Select("SELECT matches.id, matches.user1, matches.user2, matches.user1Hand, matches.user2Hand FROM matches")
  ArrayList<Match> selectAllMatch();

  @Insert("INSERT INTO matches (user1,user2,user1Hand,user2Hand) VALUES(#{user1},#{user2},#{user1Hand},#{user2Hand})")

  void insertUserInfo(Match matches);

}
