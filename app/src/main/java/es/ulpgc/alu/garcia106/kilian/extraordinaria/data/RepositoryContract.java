package es.ulpgc.alu.garcia106.kilian.extraordinaria.data;

import java.util.List;

public interface RepositoryContract {

  interface LoadItemListCallback{
    void setItemList(List<Item> itemList);
  }

  interface OnAddNewItemCallback{
    void setItemList(List<Item> itemList);
  }

  void addNewItem(OnAddNewItemCallback callback);

  void getItemList(LoadItemListCallback callback);
}
