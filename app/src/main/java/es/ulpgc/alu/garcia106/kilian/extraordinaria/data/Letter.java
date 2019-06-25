package es.ulpgc.alu.garcia106.kilian.extraordinaria.data;

public class Letter {

  private int id;

  private char letter;

  public Letter(int id){
    this.id = id;
    this.letter = 'A';
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public char getLetter() {
    return letter;
  }

  public void setLetter(char letter) {
    this.letter = letter;
  }

}
