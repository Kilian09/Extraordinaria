package es.ulpgc.alu.garcia106.kilian.extraordinaria.master;

import java.lang.ref.WeakReference;

import es.ulpgc.alu.garcia106.kilian.extraordinaria.data.Letter;
import es.ulpgc.alu.garcia106.kilian.extraordinaria.data.RepositoryContract;
import es.ulpgc.alu.garcia106.kilian.extraordinaria.detail.DetailState;

interface MasterContract {

  interface View {
    void injectPresenter(Presenter presenter);

    void displayData(MasterViewModel viewModel);
  }

  interface Presenter {
    void injectView(WeakReference<View> view);

    void injectModel(Model model);

    void injectRouter(Router router);

    void fetchData();

    void onAddButtonClicked();

    void onListItemClicked(Letter letter);
  }

  interface Model {
    String fetchData();

    void addNewItem(RepositoryContract.OnAddNewItemCallback callback);

    void LoadItemList(RepositoryContract.LoadItemListCallback callback);
  }

  interface Router {
    void navigateToDetailScreen();

    void passDataToDetailScreen(DetailState state);

    MasterState getDataFromPreviousScreen();
  }
}
