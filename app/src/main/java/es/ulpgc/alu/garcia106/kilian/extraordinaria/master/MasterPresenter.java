package es.ulpgc.alu.garcia106.kilian.extraordinaria.master;

import java.lang.ref.WeakReference;
import java.util.List;

import es.ulpgc.alu.garcia106.kilian.extraordinaria.data.Letter;
import es.ulpgc.alu.garcia106.kilian.extraordinaria.data.RepositoryContract;
import es.ulpgc.alu.garcia106.kilian.extraordinaria.detail.DetailState;

public class MasterPresenter implements MasterContract.Presenter {

  public static String TAG = MasterPresenter.class.getSimpleName();

  private WeakReference<MasterContract.View> view;
  private MasterViewModel viewModel;
  private MasterContract.Model model;
  private MasterContract.Router router;

  public MasterPresenter(MasterState state) {
    viewModel = state;
  }

  @Override
  public void injectView(WeakReference<MasterContract.View> view) {
    this.view = view;
  }

  @Override
  public void injectModel(MasterContract.Model model) {
    this.model = model;
  }

  @Override
  public void injectRouter(MasterContract.Router router) {
    this.router = router;
  }

  @Override
  public void fetchData() {
    // Log.e(TAG, "fetchData()");
/*
    // set passed state
    MasterState state = router.getDataFromPreviousScreen();
    if (state != null) {
      viewModel.data = state.data;
    }

    if (viewModel.data == null) {
      // call the model
      String data = model.fetchData();

      // set initial state
      viewModel.data = data;
    }
*/
    if (viewModel.letters == null) {
      model.LoadItemList(new RepositoryContract.LoadItemListCallback() {
        @Override
        public void setItemList(List<Letter> letterList) {
          viewModel.letters = letterList;
        }
      });
    }
    // update the view
    view.get().displayData(viewModel);

  }

  @Override
  public void onAddButtonClicked() {
    model.addNewItem(new RepositoryContract.OnAddNewItemCallback() {
      @Override
      public void setItemList(List<Letter> letterList) {
        viewModel.letters = letterList;
        view.get().displayData(viewModel);
      }
    });
  }

  @Override
  public void onListItemClicked(Letter letter) {
    DetailState state = new DetailState();
    state.letter = letter;
    router.passDataToDetailScreen(state);
    router.navigateToDetailScreen();
  }
}
