package es.ulpgc.alu.garcia106.kilian.extraordinaria.data;

import java.util.List;

public interface RepositoryContract {

  interface LoadItemListCallback{
    void setItemList(List<Letter> letterList);
  }

  interface OnAddNewItemCallback{
    void setItemList(List<Letter> letterList);
  }


  void addNewItem(OnAddNewItemCallback callback);

  void getItemList(LoadItemListCallback callback);



}
