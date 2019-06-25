package es.ulpgc.alu.garcia106.kilian.extraordinaria.data;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

public class Repository implements RepositoryContract {

  private static Repository INSTANCE = null;
  private Context context;
  private List<Letter> letters;
  private List<Number> numbers;

  private Repository(Context context) {
    this.context = context;
    this.letters = new ArrayList<>();
  }

  public static Repository getInstance(Context context) {
    if (INSTANCE == null) {
      INSTANCE = new Repository(context);
    }
    return INSTANCE;
  }

  @Override
  public void addNewItem(OnAddNewItemCallback callback) {
    if (callback != null) {
      int size = letters.size();
      letters.add(new Letter(size));
      callback.setItemList(letters);
    }
  }

  @Override
  public void getItemList(LoadItemListCallback callback) {
    if (callback != null) {
      callback.setItemList(letters);
    }
  }
}
