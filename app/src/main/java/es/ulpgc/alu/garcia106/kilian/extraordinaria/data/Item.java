package es.ulpgc.alu.garcia106.kilian.extraordinaria.data;

public class Item {

  private int id;

  private String letter;

  public Item(int id,String letter){
    this.id = id;
    this.letter = letter;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getLetter() {
    return letter;
  }

  public void setLetter(String letter) {
    this.letter = letter;
  }
}
