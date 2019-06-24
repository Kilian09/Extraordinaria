package es.ulpgc.alu.garcia106.kilian.extraordinaria.data;

import android.content.Context;

public class Repository implements RepositoryContract {

  private static Repository INSTANCE = null;
  private Context context;

  //private List<Item> items;

  private Repository(Context context) {
    this.context = context;
  }

  public static Repository getInstance(Context context) {
    if (INSTANCE == null) {
      INSTANCE = new Repository(context);
    }
    return INSTANCE;
  }

}
