package es.ulpgc.alu.garcia106.kilian.extraordinaria.data;

public class Number {

  private int id;

  private int count;
  private int letterId;

  public Number(int id,int letterId){
    this.id = id;
    count = 0;
    this.letterId = letterId;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getCount() {
    return count;
  }

  public void setCount(int count) {
    this.count = count;
  }

  public int getLetterId() {
    return letterId;
  }

  public void setLetterId(int letterId) {
    this.letterId = letterId;
  }
}
