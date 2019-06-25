package es.ulpgc.alu.garcia106.kilian.extraordinaria.master;

import android.util.Log;

import java.lang.ref.WeakReference;

import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.FragmentActivity;

import es.ulpgc.alu.garcia106.kilian.extraordinaria.data.Repository;
import es.ulpgc.alu.garcia106.kilian.extraordinaria.data.RepositoryContract;

public class MasterModel implements MasterContract.Model {

  public static String TAG = MasterModel.class.getSimpleName();

  private Repository repository;

  public MasterModel(Repository repository) {
    this.repository = repository;
  }

  @Override
  public String fetchData() {
    // Log.e(TAG, "fetchData()");
    return "Hello";
  }

  @Override
  public void addNewItem(RepositoryContract.OnAddNewItemCallback callback){
  repository.addNewItem(callback);
  }

  @Override
  public void LoadItemList(RepositoryContract.LoadItemListCallback callback){
    repository.getItemList(callback);
  }
}
