package es.ulpgc.alu.garcia106.kilian.extraordinaria.data;

import android.content.Context;

import java.util.List;

public class Repository implements RepositoryContract {

  private static Repository INSTANCE = null;
  private Context context;

  private List<Item> items;

  private Repository(Context context) {
    this.context = context;
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
      items.add(new Item(items.size(), getLetra(items.size())));
      callback.setItemList(items);
    }
  }

  @Override
  public void getItemList(LoadItemListCallback callback) {
    if (callback != null) {
      callback.setItemList(items);
    }
  }

  public String getLetra(int id){
    for(int i = 0; i<items.size();i++){
      if(items.get(i).getId() == id){
        return items.get(i).getLetter();
      }
    }
    return "No hay letra";
  }
}
